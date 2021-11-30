package org.lanqiao.Contorller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.lanqiao.pojo.AdminUser;
import org.lanqiao.service.AdminUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class AdminUserContorller {
	@Resource
	AdminUserService adminUserService;

	@PostMapping("/adminUser_login")
	public String login(AdminUser adminUser, Model model, HttpSession httpSession, String userCode) {
		String sysCode = (String) httpSession.getAttribute("sysCode");
		if (sysCode.equalsIgnoreCase(userCode)) {
			QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
			queryWrapper.eq("USER_NAME", adminUser.getUserName());
			queryWrapper.eq("password", adminUser.getPassword());
			AdminUser one = adminUserService.getOne(queryWrapper);
			if (one != null) {
				if (one.getState() == 1) {
					httpSession.setAttribute("admin", one);
					return "index";
				} else {
					model.addAttribute("message", "该账户被禁用！");
					return "login";
				}
			} else {
				System.out.println("登录失败");
				model.addAttribute("message", "账号或密码错误！");
				return "login";
			}
		} else {
			model.addAttribute("message", "验证码错误！");
			return "login";
		}

	}
	@GetMapping("adminUser_logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
}
