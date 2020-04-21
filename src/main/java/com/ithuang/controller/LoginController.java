package com.ithuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ithuang.common.Result;
import com.ithuang.entities.dto.UserInfo;


@Controller
@RequestMapping("/user")
public class LoginController {
	
	@RequestMapping("/login")
	@ResponseBody
	public Result login(@RequestBody UserInfo userInfo) {
		String passWord = userInfo.getPassWord();
		String userName = userInfo.getUserName();
		if ("admin".equals(passWord) && "admin".equals(userName)) {
			return Result.ok();
		}
		return Result.error("验证失败");
	}
}
