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
	/**
	 * 根据email查询数据
	 * @param email 要查询的email
	 * @return 如果存在返回非0 不存在返回0
	 */
	Integer getCountByEmail(String email);
	/**
	 * 通过电话号码查询数据
	 * @param phone 要查询的电话
	 * @return	如果存在返回非0,不存在返回0
	 */
	Integer getCountByPhone(String phone);
}
