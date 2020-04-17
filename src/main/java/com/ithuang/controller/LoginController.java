package com.ithuang.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/user/login")
	public String login(@RequestParam("username") String userName, @RequestParam("password") String passWord,
			Map<String, Object> map, HttpSession session) {
		if (!userName.isEmpty() && "12345".equals(passWord)) {
			session.setAttribute("username", userName);
			return "redirect:/main.html";
		}
		map.put("msg", "用户名密码错误");
		return "login";
	}
	
	@RequestMapping(value = "/user/login1")
	@ResponseBody
	public String login1(@RequestParam("username") String userName, @RequestParam("password") String passWord,
			Map<String, Object> map, HttpSession session) {
		if (!userName.isEmpty() && "12345".equals(passWord)) {
			return "1";
		}
		return "0";
	}
}
