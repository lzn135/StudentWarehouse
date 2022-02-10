package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {

	@Resource
	private  SuccessKilledDao successKilledDao;

	@Test
	public void insertSuccessKilled() {
		successKilledDao.insertSuccessKilled(1000,15823431710L);
	}

	@Test
	public void queryByIdWithSecKill() {
		SuccessKilled successKilled = successKilledDao.queryByIdWithSecKill(1000,15823431710L);
		System.out.println(successKilled);
		System.out.println(successKilled.getSecKill());
	}
}