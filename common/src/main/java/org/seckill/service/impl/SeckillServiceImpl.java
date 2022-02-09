package org.seckill.service.impl;

import org.apache.commons.collections.MapUtils;
import org.seckill.dao.SecKillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.*;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeckillServiceImpl implements SeckillService {
	// MD5 盐值字符串，用来混淆 MD5
	private final String slat = "njxdchviangaidjvoamv#@%#%￥%%&%#%2387453";

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SecKillDao secKillDao;

	@Autowired
	private SuccessKilledDao successKilledDao;

	@Override
	public List<Seckill> getSeckillList() {
		return secKillDao.queryAll(0,10);
	}

	@Override
	public Seckill getById(long seckillId) {
		return secKillDao.queryById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = secKillDao.queryById(seckillId);
		if (seckill ==null){
			return new Exposer(false,seckillId);
		}else {
			Date starTime = seckill.getStartTime();
			Date endTime  = seckill.getEndTime();
			Date nowTime  = new Date();
			if (nowTime.getTime()< starTime.getTime() || nowTime.getTime()> endTime.getTime()){
				return new Exposer(false,seckillId,nowTime.getTime(),starTime.getTime(),endTime.getTime());
			}
		}
		String md5 = getMD5(seckillId);
		return new Exposer(true,md5,seckillId);
	}

	@Override
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SecurityException, RepeatKillException, SeckillCloseException {
		if (!md5.equals(getMD5(seckillId))||md5 ==null){
			throw new SeckillCloseException("seckill data  rewrite");

		}
		Date nowTime = new Date();
		try {
			//记录购买行为
			int insertCount  = successKilledDao.insertSuccessKilled(seckillId,userPhone);
			if (insertCount <=0){
				//重复秒杀
				throw new RepeatKillException("seckill repeated");
			}else {
				//热点商品竞争
				int updateCount = secKillDao.reduceNumber(seckillId, nowTime);
				if (updateCount <0){
					//没有更新到记录，秒杀结束
					throw new SeckillCloseException("seckill is closed");
				}else {
					//秒杀成功
					SuccessKilled successKilled =successKilledDao.queryByIdWithSecKill(seckillId,userPhone);
					return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS,successKilled);
				}
			}
		}catch (SeckillCloseException e1){
			throw e1;
		}catch (RepeatKillException e2){
			throw e2;
		}catch (Exception e){
			logger.error(e.getMessage(),e);
			//所有编译器异常转化为运行期异常
			throw new SeckillException("seckill inner error"+e.getMessage());
		}
	}
	/**
	 * 使用存储过程完成秒杀,这里是后面的高并发优化内容，存储过程还没有创建，所以这个方法暂时是没用的
	 *
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return
	 * @throws SeckillException
	 * @throws RepeatKillException
	 * @throws SeckillCloseException
	 */
	@Override
	public SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5) {
		if (!md5.equals(getMD5(seckillId)) || md5 ==null){
			//MD5验证失败时，返回数据篡改异常
			return new SeckillExecution(seckillId, SeckillStatEnum.DATA_REWRITE);
		}
		Date killTime = new Date();
		Map<String,Object> map = new HashMap<>();
		map.put("seckillId",seckillId);
		map.put("phone",userPhone);
		map.put("killTime",killTime);
		map.put("result",null);
		//存储过程执行完毕	，result被赋值
		try {
			secKillDao.killByProcedure(map);
			//获取result
			Integer result = MapUtils.getInteger(map,"result",-2);
			if (result==1){
				SuccessKilled sk = successKilledDao.queryByIdWithSecKill(seckillId,userPhone);
				return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS,sk);
			}else {
				return new SeckillExecution(seckillId,SeckillStatEnum.stateOf(result));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),  e);
			return new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
		}

	}

	private String getMD5(long seckillId) {
		String base = seckillId + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
}
