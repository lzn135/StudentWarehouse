package org.lanqiao.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("org.lanqiao.mapper")
public class MybatisPlusConfig {
	@Bean
	public PaginationInterceptor paginationInterceptor(){
		PaginationInterceptor paginationInterceptor = paginationInterceptor();
//		paginationInterceptor.setDialectType("mysql");
		return paginationInterceptor;

	}
}
