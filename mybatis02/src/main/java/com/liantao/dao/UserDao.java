package com.liantao.dao;
 
import java.util.List;
import com.liantao.pojo.User;
 
public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * 根据id删除用户
	 * @param id
	 */
	public void deleteUser(Long id);
	/**
	 * 更新用户信息
	 * @param user
	 */
	public void updateUserById(User user);
	/**
	 * 根据用户id返回用户信息
	 * @param id
	 * @return
	 */
	public User findUserById(Long id);
	/**
	 * 根据用户名和密码返回用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	public User findUserByNameAndPwd(User user);
	/**
	 * 返回所有用户信息
	 * @return List<User>
	 */
	public List<User> findUserAll();
	void deleteUserById(Long id);
	void updateUser(User user);
}
