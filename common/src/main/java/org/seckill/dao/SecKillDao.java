package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;


import java.util.Date;
import java.util.List;
import java.util.Map;

// 这里的方法名中的参数名前面都加了个 @Param 的注解，意思是这个参数被引用的时候的参数名，建议都加上

// 一般来说接口是为了为相应的实体进行操作的
public interface SecKillDao {
	/**
	 * 减少库存
	 * @param secKillId 秒杀商品ID
	 * @param killTime  秒杀时间
	 * @return
	 */
	int reduceNumber(@Param("secKillId") long secKillId,@Param("killTime") Date killTime);
	/**
	 * 根据 ID 查询秒杀对象
	 * @param secKillId
	 * @return
	 */
	Seckill queryById(@Param("secKillId") long secKillId);
	/**
	 * 根据偏移量查询秒杀列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	/**
	 * 使用存储过程进行秒杀
	 * @param paramMap
	 */
	void killByProcedure(Map<String, Object> map);
}