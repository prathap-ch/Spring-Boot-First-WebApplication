package com.skillUp.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return service.findAllUsers();
	}

	@GetMapping("/users/{id}")
	public EntityModel<Users> retrieveUser(@PathVariable int id) throws UserNotFoundException {
		Users user = service.findOne(id);
		if (null == user)
			throw new UserNotFoundException("user not found with given details");
		EntityModel<Users> model = EntityModel.of(user);
		WebMvcLinkBuilder linktoUser=linkTo(methodOn(this.getClass()).getAllUsers()); 
		model.add(linktoUser.withRel("all-users"));
		return model;
	}

	@PostMapping("/user")
	public ResponseEntity<Object> save(@Valid @RequestBody Users user) {
		Users savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("allUsers/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PostMapping("/user/{id}")
	public void delete(@PathVariable int id) throws UserNotFoundException {
		service.delete(id);
	}
}
