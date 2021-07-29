package com.skillUp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import com.skillUp.beans.Users;

@Component
public class UsersDaoService {
	private static List<Users> userList = new ArrayList<>();
	private  int count = 3;
	static {
		userList.add(new Users(1, "A", new Date()));
		userList.add(new Users(2, "B", new Date()));
		userList.add(new Users(3, "C", new Date()));
	}

	public List<Users> findAllUsers() {
		return userList;
	}
	
	public  void addUser() {
		userList.add(new Users(++count, "D", new Date()));
	}
	
	public Users save(Users user) {
		if(user.getId()==0)
			user.setId(++count);
		userList.add(user);
		return user;
	}
	
	public Users findOne(int id) {
		return userList.stream().filter(user->user.getId()==id).findAny().orElse(null); 
	}
}
