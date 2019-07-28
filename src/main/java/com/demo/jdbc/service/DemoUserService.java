package com.demo.jdbc.service;

import com.demo.jdbc.domain.DemoUser;

public interface DemoUserService {

	DemoUser getUser(String username);

	void updateUser(DemoUser demoUser);

	void registerUser(DemoUser demoUser);

	void deleteUser(String username);
}