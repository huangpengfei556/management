package com.ithuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ithuang.dao.UserRepository;
import com.ithuang.entities.eo.UserEO;
import com.ithuang.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public void insertUser(String userName, String passWord) {
		UserEO user = new UserEO();
		user.setUserName(userName);
		user.setPassWord(passWord);
		userRepository.save(user);
	}

	@Override
	public boolean authUser(String userName, String passWord) {
		List<UserEO> list = userRepository.queryByUserNameAndPassword(userName, passWord);
		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean getUserName(String userName) {
		List<UserEO> list = userRepository.queryByUserName(userName);
		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
