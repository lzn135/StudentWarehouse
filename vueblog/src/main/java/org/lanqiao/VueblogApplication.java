package org.lanqiao;

import org.lanqiao.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sun.awt.SunHints;

@SpringBootApplication
@MapperScan("org.lanqiao.mapper")
public class VueblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueblogApplication.class, args);
	}

}
