package com.pangw.mydao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pangw.mybatistest.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public User queryUserById(int id) {
		// TODO Auto-generated method stub
		// 创建SqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 执行查询逻辑
		User user = sqlSession.selectOne("queryUserById", id);
		// 释放资源
		sqlSession.close();

		return user;
	}

	@Override
	public List<User> queryUserByUserName(String username) {
		// TODO Auto-generated method stub
		// 创建SqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		// 执行查询逻辑
		List<User> list = sqlSession.selectList("queryUserByUsername", username);
		// 释放资源
		sqlSession.close();

		return list;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		// 创建SqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		// 执行保存逻辑
		sqlSession.insert("saveUser", user);
		// 提交事务
		sqlSession.commit();
		// 释放资源
	}

}
