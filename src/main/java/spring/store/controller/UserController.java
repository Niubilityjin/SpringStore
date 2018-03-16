package spring.store.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.store.bean.ResponseResult;
import spring.store.bean.User;
import spring.store.service.IUserService;
import spring.store.service.ex.UsernameAlreadyExistException;



@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";
	}
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> rr;
		//返回true说明用户名存在
		//返回false说明用户名不存在
		if(userService.checkUsername(username)) {
			rr=new ResponseResult<Void>(0, "用户名已存在");
		}else {
			rr=new ResponseResult<Void>(1, "用户名可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr;
		//返回true说明用户名存在
		//返回false说明用户名不存在
		if(userService.checkPhone(phone)) {
			rr=new ResponseResult<Void>(0, "该手机号码已存在");
		}else {
			rr=new ResponseResult<Void>(1, "该手机号码可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr;
		//返回true说明用户名存在
		//返回false说明用户名不存在
		if(userService.checkEmail(email)) {
			rr=new ResponseResult<Void>(0, "该邮箱地址已存在");
		}else {
			rr=new ResponseResult<Void>(1, "该邮箱地址可以使用");
		}
		return rr;
	}
	@RequestMapping("/register.do")
	//响应JSON回来
	@ResponseBody
	public ResponseResult<Void> register(
			@RequestParam("uname") String username,
			@RequestParam("upwd") String password,
			String email,String phone){
		ResponseResult<Void> rr;
		System.out.println("++++++"+username+password+email+phone);
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		try {
			userService.register(user);
			rr=new ResponseResult<Void>(1, "注册成功");
		} catch (UsernameAlreadyExistException e) {
			rr=new ResponseResult<Void>(0, e.getMessage());
		}
		return rr;
		
	}
}

