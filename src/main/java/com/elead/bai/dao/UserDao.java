package com.elead.bai.dao;

import java.util.*;

import com.elead.bai.pojo.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao
{

	private static Map<Integer, UserBean> userMap = new HashMap<>();
	
	private static List<String> SHENFEN_LIST = new ArrayList<>();

	static
	{
		UserBean user1 = new UserBean(10000, "张三", "男", 21);
		UserBean user2 = new UserBean(10001, "李四", "男", 22);
		userMap.put(10000, user1);
		userMap.put(10001, user2);
		
		SHENFEN_LIST.add("北京");
		SHENFEN_LIST.add("上海");
		SHENFEN_LIST.add("广东");
		SHENFEN_LIST.add("湖南");
		SHENFEN_LIST.add("湖北");
		SHENFEN_LIST.add("广西");
	}

	public boolean addUser(UserBean user)
	{
		userMap.put(user.getUserid(), user);
		System.out.println("添加用户成功, username:" + user.getUsername());
		return true;
	}

	public UserBean findUser(Integer userid)
	{
		return userMap.get(userid);
	}

	public static List<String> getEnumList(String enumName)
	{
		if("shenfen".equalsIgnoreCase(enumName)){
			return SHENFEN_LIST;
		}
		return Collections.emptyList();
	}
}
