package com.elead.bai.service;

import com.elead.bai.dao.UserDao;
import com.elead.bai.pojo.UserBean;
import com.elead.bai.utils.EleadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{

	@Autowired
	private UserDao userDao;

	public boolean addUser(UserBean user)
	{
		//EleadUtil.checkRequireParam(user.getUserid(), user.getUsername());
		EleadUtil.validate(user);
		return userDao.addUser(user);
	}

	public UserBean findUser(Integer userid)
	{
		EleadUtil.checkRequireParam("userid", userid);
		return userDao.findUser(userid);
	}
}
