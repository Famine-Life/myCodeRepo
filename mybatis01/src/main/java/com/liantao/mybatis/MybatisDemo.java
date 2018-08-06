package com.liantao.mybatis;

import java.io.IOException;
import java.io.InputStream;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.liantao.pojo.User;
 
public class MybatisDemo {
	public static void main(String[] args) throws IOException {
		//mybatis配置文件    默认路径org/mybatis/example/mybatis-config.xml
		String resource = "mybatis-config.xml";
		//读取配置文件信息
		InputStream is = Resources.getResourceAsStream(resource );
		//构件SqlSessionFactory
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		//获取sqlSession
		SqlSession session = sf.openSession();
		try {
			  //参数1  标识要寻找的statement对象  即UserMapper.xml    参数2 标识要传入的参数
			  User user = (User) session.selectOne("UserMapper.selectUser", 1);
			  System.out.println(user);
		} finally {
		   //关闭sqlSession
		   session.close();
		}
	}
}
