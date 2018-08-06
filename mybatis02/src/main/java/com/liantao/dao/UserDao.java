package com.liantao.dao;
 
import java.util.List;
import com.liantao.pojo.User;
 
public interface UserDao {
	/**
	 * ����û�
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * ����idɾ���û�
	 * @param id
	 */
	public void deleteUser(Long id);
	/**
	 * �����û���Ϣ
	 * @param user
	 */
	public void updateUserById(User user);
	/**
	 * �����û�id�����û���Ϣ
	 * @param id
	 * @return
	 */
	public User findUserById(Long id);
	/**
	 * �����û��������뷵���û���Ϣ
	 * @param username
	 * @param password
	 * @return
	 */
	public User findUserByNameAndPwd(User user);
	/**
	 * ���������û���Ϣ
	 * @return List<User>
	 */
	public List<User> findUserAll();
	void deleteUserById(Long id);
	void updateUser(User user);
}
