package com.demo.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.jdbc.dao.DemoUserDao;
import com.demo.jdbc.domain.DemoUser;
import com.demo.jdbc.exception.DemoUserFoundException;
import com.demo.jdbc.exception.DemoUserNotFoundException;
import com.demo.jdbc.service.DemoUserService;

@Service
public class DemoUserServiceImpl implements DemoUserService {

	@Autowired
	private DemoUserDao demoUserDao;

	@Override
	public DemoUser getUser(String username) {
		DemoUser demoUser = demoUserDao.getUser(username);
		if (ObjectUtils.isEmpty(demoUser)) {
			throw new DemoUserNotFoundException();
		}
		return demoUser;
	}

	@Override
	public void updateUser(DemoUser demoUser) {
		DemoUser userDb = getUser(demoUser.getUsername());
		if (!userDb.equals(demoUser)) {
			demoUserDao.updateUser(demoUser);
		}
	}

	@Override
	public void registerUser(DemoUser demoUser) {
		if (!ObjectUtils.isEmpty(demoUserDao.getUser(demoUser.getUsername()))) {
			throw new DemoUserFoundException();
		}
		demoUserDao.registerUser(demoUser);
	}

	@Override
	public void deleteUser(String username) {
		getUser(username);
		demoUserDao.deleteUser(username);
	}
}