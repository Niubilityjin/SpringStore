package spring.store.mapper;

import spring.store.bean.User;

public interface UserMapper {
	/**
	 * 添加用户信息
	 * @param user
	 */
	void insert(User user);
	/**
	 * 根据用户名查询用户信息
	 * @param username 传入的用户名
	 * @return
	 */
	User getUserByUsername(String username);
}
