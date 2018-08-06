package com.liantao.test;
 
import static org.junit.Assert.fail;
 
import java.io.InputStream;
import java.util.Date;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
 
import com.liantao.dao.UserDao;
import com.liantao.dao.impl.UserDaoImpl;
import com.liantao.pojo.User;
 
public class UserDaoTest {
	SqlSession sqlSession =null;
	UserDao userDao  =null;
	@Before
	public void setUp() throws Exception {
		//mybatis�����ļ� 
		String resource = "mybatis-config.xml";
		//��ȡ�����ļ���Ϣ
		InputStream is = Resources.getResourceAsStream(resource );
		//����SqlSessionFactory
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		//��ȡsqlSession
		sqlSession = sf.openSession();
		userDao = new UserDaoImpl(sqlSession);
	}
 
	@Test
	public void testAddUser() {
		
		User user = new User();
		user.setuserName("dsadsad");
		user.setPassword("sadsadsa");
		user.setName("1234dsa");
		user.setAge(18);
		user.setSex(2);
		user.setBirthday(new Date());
		userDao.addUser(user);
		System.out.println(user.toString());
		sqlSession.commit();
	}
 
	@Test
	public void testDeleteUserById() {
		userDao.deleteUserById(36l);
		sqlSession.commit();
	}
 
	@Test
	public void testUpdateUser() {
		User user = userDao.findUserById(37l);
		user.setName("����");
		userDao.updateUser(user);
		sqlSession.commit();
		
	}
 
	@Test
	public void testFindUserById() {
		User user = userDao.findUserById(26l);
		System.out.println(user.toString());
	}
 
	@Test
	public void testFindUserByNameAndPwd() {
		User user = new User();
		user.setuserName("123");
		user.setPassword("123");
		user = userDao.findUserByNameAndPwd(user);
		System.out.println(user.toString());
	}
 
	@Test
	public void testFindUserAll() {
		List<User> findUserAll = userDao.findUserAll();
		for (User user : findUserAll) {
			System.out.println(user.toString());
		}
	}
	
}
