package com.demo.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.jdbc.domain.DemoUser;
import com.demo.jdbc.exception.DemoUserFoundException;
import com.demo.jdbc.exception.DemoUserNotFoundException;
import com.demo.jdbc.repository.DemoUserRepository;
import com.demo.jdbc.service.DemoUserService;

@Service
public class DemoUserServiceImpl implements DemoUserService {

	@Autowired
	private DemoUserRepository demoUserRepository;

	@Override
	public DemoUser getUser(String username) {
		DemoUser demoUser = demoUserRepository.getUser(username);
		if (ObjectUtils.isEmpty(demoUser)) {
			throw new DemoUserNotFoundException();
		}
		return demoUser;
	}

	@Override
	public void updateUser(DemoUser demoUser) {
		DemoUser userDb = getUser(demoUser.getUsername());
		if (!userDb.equals(demoUser)) {
			demoUserRepository.updateUser(demoUser);
		}
	}

	@Override
	public void registerUser(DemoUser demoUser) {
		if (!ObjectUtils.isEmpty(demoUserRepository.getUser(demoUser.getUsername()))) {
			throw new DemoUserFoundException();
		}
		demoUserRepository.registerUser(demoUser);
	}

	@Override
	public void deleteUser(String username) {
		getUser(username);
		demoUserRepository.deleteUser(username);
	}
}