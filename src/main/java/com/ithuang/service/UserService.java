package com.ithuang.service;

public interface UserService {

	void insertUser(String userName, String passWord);

	boolean authUser(String userName, String passWord);

	boolean getUserName(String userName);
}
