package org.lanqiao.controler;


import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yyds
 * @since 2021-05-14
 */
@RestController
@RequestMapping("/user")
@MapperScan("org.lanqiao.mapper")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/index")
	public Object index(){
		return  userService.getById(1L);

	}
}
