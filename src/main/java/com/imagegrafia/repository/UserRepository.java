package com.imagegrafia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.imagegrafia.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	public User findOneByName(String name);

}
