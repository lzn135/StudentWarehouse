package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SecKillDaoTest {

	@Resource
	private SecKillDao secKillDao;

	@Test
	public void reduceNumber() {

	}

	@Test
	public void queryById() {
		long id = 1000;
		Seckill seckill = secKillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}

	@Test
	public void queryAll() {
		System.out.println(secKillDao.queryAll(0,2));
	}
}