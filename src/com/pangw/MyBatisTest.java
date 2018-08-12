package com.pangw;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.xml.crypto.Data;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pangw.mybatistest.User;

public class MyBatisTest {

	private static SqlSessionFactory sqlSessionFactory = null;
	
	
	public static void init() throws IOException{
		//1、创建sqlsessionfactoryBuilder对象
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		
		//2、加载sqlMapConfig.xml配置对象
		InputStream inputStream  = Resources.getResourceAsStream("SqlMapConfig.xml");
		
		//3、创建sqlsessionFactory对象
		sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
		
		}
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		init();
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
//		User object = sqlSession.selectOne("queryUserById",1);		
//		
//		System.out.println(object.toString());
		
		
//		List<User> list = sqlSession.selectList("queryUserByUsername1","%王%");
//
//		for(User u:list){
//			System.out.println(u.toString());
//		}
		
		
//		List<User> list = sqlSession.selectList("queryUserByUsername2","王");
//
//		for(User u:list){
//			System.out.println(u.toString());
//		}
		
		
//		User user = new User();
//		user.setUsername("张飞");
//		user.setSex("1");
//		user.setBirthday(new Date());
//		user.setAddress("蜀国");
//		sqlSession.insert("saveUser3",user);
//		//注意要添加事务提交
//		sqlSession.commit();

		
		
//		User user = new User();
//		user.setUsername("关羽");
//		user.setSex("1");
//		user.setId(34);
//		user.setBirthday(new Date());
//		user.setAddress("蜀国");
//		sqlSession.update("updateUserById",user);
//		//注意要添加事务提交
//		sqlSession.commit();	
		
		
//		sqlSession.delete("deleteUserById",34);
//		sqlSession.commit();
		
		
		sqlSession.close();
	}
}
