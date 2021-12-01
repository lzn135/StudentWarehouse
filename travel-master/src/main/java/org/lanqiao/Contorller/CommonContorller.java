package org.lanqiao.Contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonContorller {

	@GetMapping("/")
	public String toProtalIndex(){
		return "portal/index";
	}

	@GetMapping("login")
	public  String toLogin(){
		return "login";
	}
}

