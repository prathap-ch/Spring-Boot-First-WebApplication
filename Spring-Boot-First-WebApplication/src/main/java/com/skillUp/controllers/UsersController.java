package com.skillUp.controllers;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.skillUp.beans.Users;
import com.skillUp.dao.UsersDaoService;
import com.skillUp.exceptions.UserNotFoundException;

@RestController
public class UsersController {
	@Autowired
	UsersDaoService service;

	@GetMapping("/allUsers")
	public List<Users> getAllUsers() {
		return service.findAllUsers();
	}
	
	@GetMapping("/allUsers/{id}")
	public Users getOne(@PathVariable int id) throws UserNotFoundException {
		Users user = service.findOne(id);
		if(null== user)
			throw new UserNotFoundException("user not found with given details");
		
		return user;
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> save(@RequestBody Users user) {
		Users savedUser=service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("allUsers/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
}
