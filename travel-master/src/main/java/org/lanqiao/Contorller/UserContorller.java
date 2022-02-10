package org.lanqiao.Contorller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.lanqiao.pojo.User;
import org.lanqiao.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserContorller {

	@Resource
	UserService userService;

	@GetMapping("/user_login")
	public  String tologin(){
		return "portal/login";

	}

	@PostMapping("user_login")
	public String login ( User user,
						  Model model,
						  HttpSession session,
						  String userCode) {
		String sysCode = (String) session.getAttribute("sysCode");
		if (sysCode.equalsIgnoreCase(userCode)) {
			QueryWrapper queryWrapper = new QueryWrapper();
			queryWrapper.eq("USER_NAME", user.getUserName());
			queryWrapper.eq("PASSWORD", user.getPassword());
			queryWrapper.eq("DELETE_STATUS","0");
			User loginUser = userService.getOne(queryWrapper);
			if ( loginUser!= null) {
				if (loginUser.getState() == 1) {
					System.out.println("登陆成功"+loginUser);
					session.setAttribute("user", loginUser);
					return "portal/personalIntro";
				} else {
					model.addAttribute("message", "该账户被禁用！");
					return "portal/login";
				}
			} else {
				System.out.println("登录失败");
				model.addAttribute("message", "账号或密码错误！");
				return "portal/login";
			}
		} else {
			model.addAttribute("message", "验证码错误！");
			return "portal/login";
		}
	}
}
