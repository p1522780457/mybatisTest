package com.pangw.mydao;

import java.util.List;

import com.pangw.mybatistest.User;

public interface UserDao {

	/**
	 * 根据id查用户
	 */
	User queryUserById(int id);

	/**
	 * 根据用户名模糊查询用户
	 */
	List<User> queryUserByUserName(String username);

	/**
	 * 保存用户
	 */
	void saveUser(User user);
}
