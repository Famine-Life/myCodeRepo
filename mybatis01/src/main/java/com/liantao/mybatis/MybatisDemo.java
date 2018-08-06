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
		//mybatis�����ļ�    Ĭ��·��org/mybatis/example/mybatis-config.xml
		String resource = "mybatis-config.xml";
		//��ȡ�����ļ���Ϣ
		InputStream is = Resources.getResourceAsStream(resource );
		//����SqlSessionFactory
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		//��ȡsqlSession
		SqlSession session = sf.openSession();
		try {
			  //����1  ��ʶҪѰ�ҵ�statement����  ��UserMapper.xml    ����2 ��ʶҪ����Ĳ���
			  User user = (User) session.selectOne("UserMapper.selectUser", 1);
			  System.out.println(user);
		} finally {
		   //�ر�sqlSession
		   session.close();
		}
	}
}
