package com.pangw.mybatisdao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.pangw.mybatistest.User;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws IOException {
		// 创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 加载SqlMapConfig.xml配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 创建SqlsessionFactory
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

	}

	@Test
	public void testQueryUserById() {
		// 获取sqlSession，和spring整合后由spring管理
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		// 从sqlSession中获取Mapper接口的代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 执行查询方法
		User user = userMapper.queryUserById(35);
		System.out.println(user);

		// 和spring整合后由spring管理
		sqlSession.close();
	}

	@Test
	public void testQuerUserBynames() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.queryUserByUsername("王");
		for (User u : list) {
			System.out.println(u.toString());
		}
		sqlSession.close();
	}

	@Test
	public void saveUser() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 创建保存对象
		User user = new User();
		user.setUsername("刘备");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("蜀国");

		userMapper.saveUser(user);

		sqlSession.commit();
		sqlSession.close();

	}

}
