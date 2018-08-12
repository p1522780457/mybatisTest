package com.pangw.mydao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.pangw.mybatistest.User;

public class MyDaoTest {
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
	public void test() {
		// 创建DAO
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		// 执行查询
		User user = userDao.queryUserById(35);
		System.out.println(user);

	}

}
