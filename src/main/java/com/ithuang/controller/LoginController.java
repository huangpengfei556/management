package com.ithuang.controller;

import java.awt.image.RenderedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		boolean authUser = userService.authUser(userName, passWord);
		if (authUser) {
			request.getSession().setAttribute("loginUser", userInfo);
			return Result.ok();
		} else {
			return Result.error("验证失败");
		}
	}

	@RequestMapping("/logout")
	@ResponseBody
	public Result logout(HttpServletRequest request) {
		request.getSession().removeAttribute("loginUser");
		return Result.ok();
	}

	@RequestMapping("/register")
	@ResponseBody
	public Result register(@RequestBody UserInfo userInfo, HttpServletRequest request) {
		userService.insertUser(userInfo.getUserName(), userInfo.getPassWord());
		return Result.ok();
	}

	@RequestMapping("/verifyCode")
	@ResponseBody
	public Result verifyCode() {
		String fileName = UUID.randomUUID().toString() + ".jpg";
		Map<String, Object> map = CodeUtil.generateCodeAndPic();
		try (OutputStream out = new FileOutputStream("src\\main\\resources\\static\\verifyCode\\" + fileName)) {
			ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, String> res = new HashMap<String, String>();
		// 存放验证码
		res.put("code", map.get("code").toString());
		// 存放生成的验证码BufferedImage对象
		res.put("fileName", fileName);
		return Result.ok().put(res);
	}
}
