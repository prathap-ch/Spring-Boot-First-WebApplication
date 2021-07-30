package com.skillUp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import com.skillUp.beans.Users;
import com.skillUp.exceptions.UserNotFoundException;

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
	
	public void delete(int id) throws UserNotFoundException {
		long count=userList.stream().filter(user->user.getId()==id).map(user->userList.remove(user)).count();
	if(count==0) {
		throw new UserNotFoundException("Delete unSuccessful : no user found with goven details");
	}
	}
	
	public Users findOne(int id) {
		return userList.stream().filter(user->user.getId()==id).findAny().orElse(null); 
	}
}
