package com.skillUp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skillUp.beans.HelloWorldBean;

@RestController
public class HelloWorld {

	@GetMapping(path = "/hello")
	public String hello() {
		return "Hello World using GetMapping";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/world")
	public String world() {
		return "Hello World using RequestMapping";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/helloBean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("HelloWorld from bean class");
	}
	
	@GetMapping(path = "/hello/{name}")
	public String helloPathVar(@PathVariable String name) {
		return "Hello "+name;
	}
}
