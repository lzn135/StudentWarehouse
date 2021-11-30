package org.lanqiao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.lanqiao.pojo.AdminUser;
import org.lanqiao.service.AdminUserService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TravelMasterApplicationTests {
@Resource
	AdminUserService adminUserService;
	@Test
	void contextLoads() {
		QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("USER_NAME","admin");
		queryWrapper.eq("password","admin");
		queryWrapper.eq("DELETE_STATUS",0);
		AdminUser one = adminUserService.getOne(queryWrapper);
		System.out.println(one);
	}
	@Test
	void test1(){
//		QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
//		queryWrapper.eq("USER_NAME","admin");
		int count = adminUserService.count();
		Page<AdminUser> page = adminUserService.page(new Page<>(1, 1, count));

		System.out.println(page.getSize());
		System.out.println(page.getTotal());
		System.out.println(page.getRecords());

	}

}
