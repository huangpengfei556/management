package com.ithuang;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@PostMapping("/user/login")
	public String login(String userName,String passWord,Map<String,Object> map) {
		if(!userName.isEmpty() && "12345".equals(passWord)) {
			
			return "dashboard";
		}
		map.put("msg", "用户名密码错误");
		return "login";
	}
}
