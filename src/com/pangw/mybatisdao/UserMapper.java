package com.pangw.mybatisdao;

import java.util.List;

import com.pangw.mybatistest.User;

public interface UserMapper {
	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	User queryUserById(int id);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param username
	 * @return
	 */
	List<User> queryUserByUsername(String username);

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	void saveUser(User user);

}
