package com.elead.bai.controller;

import com.elead.bai.pojo.ResultBean;
import com.elead.bai.pojo.UserBean;
import com.elead.bai.service.UserService;
import com.elead.bai.utils.EleadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController
{

	@Autowired
	private UserService userService;

	@PostMapping
	@RequestMapping("/add")
	@ResponseBody
	public ResultBean<Boolean> addUser( UserBean user)
	{
		boolean b = userService.addUser(user);
		ResultBean<Boolean> success = ResultBean.getSuccess(b);
		return success;
	}

	@GetMapping
	@RequestMapping("/findbyid")
	@ResponseBody
	public ResultBean<UserBean> findUser(Integer userid)
	{
		EleadUtil.checkRequireParam("userid", userid);
		return ResultBean.getSuccess(userService.findUser(userid));
	}
	
	@RequestMapping("/home")
	public ModelAndView home(@RequestParam("username") String username)
	{
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("username", username);
		return mv;
	}
}
