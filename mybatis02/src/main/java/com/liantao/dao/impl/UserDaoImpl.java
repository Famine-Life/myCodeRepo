package com.liantao.dao.impl;
 
 
import java.util.List;
 
 
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
 
 
import com.liantao.dao.UserDao;
import com.liantao.pojo.User;
 
 
public class UserDaoImpl implements UserDao{
	private SqlSession sqlSession;
	public UserDaoImpl(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	@Override
	public void addUser(User user) {
		sqlSession.insert("UserMapper.addUser",user);
	}
	@Override
	public void deleteUserById(Long id) {
		sqlSession.delete("UserMapper.deleteUserById",id);
	}
	@Override
	public void updateUser(User user) {
		sqlSession.update("UserMapper.updateUser",user);
	}
	@Override
	public User findUserById(Long id) {
		return sqlSession.selectOne("UserMapper.findUserById", id);
	}
	@Override
	public User findUserByNameAndPwd(User user) {
		return sqlSession.selectOne("UserMapper.findUserByNameAndPwd",user);
	}
	@Override
	public List<User> findUserAll() {
		return sqlSession.selectList("UserMapper.findUserAll");
	}
	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateUserById(User user) {
		// TODO Auto-generated method stub
		
	}
}
