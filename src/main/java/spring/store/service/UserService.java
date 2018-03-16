package spring.store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import spring.store.bean.User;
import spring.store.mapper.UserMapper;
import spring.store.service.ex.UsernameAlreadyExistException;

@Service
public class UserService implements IUserService{

	@Resource
	private UserMapper userMapper;
	/**
	 * 1.进行用户名的验证
	 * 2.如果用户名不相同，实现插入数据
	 * 3.如果用户名相同则抛出异常
	 */
	public void register(User user) {
		User user1=userMapper.getUserByUsername(user.getUsername());
		//用户名不存在
		if(user1==null) {
			userMapper.insert(user);
		}else {
			throw new UsernameAlreadyExistException("用户名已经存在,请重新输入!");
		}
		
	}
	
	/**
	 * 如果用户名存在返回true,不存在返回false
	 */
	public boolean checkUsername(String username) {
		System.out.println("++++++"+username);
		if(userMapper.getUserByUsername(username)==null) {
			return false;
		}else {
			return true;
		}
		
	}
	/**
	 * 返回false说明电话不存在
	 * 返回true说明存在
	 */
	public boolean checkPhone(String phone) {
		if(userMapper.getCountByPhone(phone)==0) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * 返回false说明邮箱不存在
	 * 返回true说明邮箱存在
	 */
	public boolean checkEmail(String email) {
		if(userMapper.getCountByEmail(email)==0) {
			return false;
		}else {
			return true;
		}
	}
	
}
