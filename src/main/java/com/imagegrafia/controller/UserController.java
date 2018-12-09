package com.imagegrafia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imagegrafia.model.User;
import com.imagegrafia.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	// create
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}

	// read by id
	
	@GetMapping("/{id}")
	public User read(@PathVariable String id) {
		return userRepository.findOne(id);
	}

	// update
	@RequestMapping(method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)

	public void update(@RequestBody User user) {
		userRepository.save(user);
	}

	// delete
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
			userRepository.delete(id);
	}
	//find user by name
	@RequestMapping(value="find/{name}")
	public User userByName(@PathVariable String name) {
		return userRepository.findOneByName(name);
	}
	//find all user 
	@RequestMapping("/all")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
}
