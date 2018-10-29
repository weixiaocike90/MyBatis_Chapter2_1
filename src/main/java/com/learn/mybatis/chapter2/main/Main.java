package com.learn.mybatis.chapter2.main;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.learn.mybatis.chapter2.mapper.RoleMapper;
import com.learn.mybatis.chapter2.pojo.Role;

public class Main {

	public static void main(String args[]) {
		String resourc = "mybatis-config.xml";
		SqlSession session  = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(resourc);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			RoleMapper roleMapper = session.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1);
			System.err.println(role.getNote());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
	}
}
