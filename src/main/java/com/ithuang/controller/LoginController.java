package com.ithuang.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ithuang.common.ManagerException;
import com.ithuang.common.Result;
import com.ithuang.entities.dto.UserInfo;
import com.ithuang.service.UserService;
import com.ithuang.utils.CodeUtil;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	@ResponseBody
	public Result login(@RequestBody UserInfo userInfo, HttpServletRequest request) {
		String passWord = userInfo.getPassWord();
		String userName = userInfo.getUserName();
		String verifyCode = request.getSession().getAttribute("VerifyCode").toString();
		/*
		 * if (!userInfo.getCode().equals(verifyCode)) { throw new
		 * ManagerException("验证码错误"); }
		 */
		boolean authUser = userService.authUser(userName, passWord);
		if (!authUser) {
			throw new ManagerException("用户名或者密码错误");
		}
		request.getSession().setAttribute("loginUser", userInfo);
		return Result.ok();
	}

	@RequestMapping("/logout")
	@ResponseBody
	public Result logout(HttpServletRequest request) {
		request.getSession().removeAttribute("loginUser");
		return Result.ok();
	}

	@RequestMapping("/register")
	@ResponseBody
	public Result register(@RequestBody UserInfo userInfo) {
		if (userService.getUserName(userInfo.getUserName())) {
			throw new ManagerException("用户名已经存在");
		}
		userService.insertUser(userInfo.getUserName(), userInfo.getPassWord());
		return Result.ok();
	}

	@RequestMapping("/registerCheck")
	@ResponseBody
	public Result registerCheck(String userName) {
		if (userService.getUserName(userName)) {
			return Result.error("用户名已经存在");
		}
		return Result.ok();
	}

	@RequestMapping("/verifyCode")
	@ResponseBody
	public Result verifyCode(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = CodeUtil.generateCodeAndPic();
		//将VerifyCode绑定session
		request.getSession().setAttribute("VerifyCode", map.get("code"));
		//设置响应头
		response.setHeader("Pragma", "no-cache");
		//设置响应头
		response.setHeader("Cache-Control", "no-cache");
		//在代理服务器端防止缓冲
		response.setDateHeader("Expires", 0);
		//设置响应内容类型
		response.setContentType("image/jpeg");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", outputStream);
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Result.ok();
	}
}
