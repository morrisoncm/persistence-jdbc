package com.demo.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jdbc.domain.DemoUser;
import com.demo.jdbc.service.DemoUserService;

@RestController
@RequestMapping("/users")
public class DemoUserController {

	@Autowired
	private DemoUserService demoUserService;

	@GetMapping("/{username}")
	public DemoUser getUser(@PathVariable String username) {
		return demoUserService.getUser(username);
	}

	@PostMapping
	public void registerUser(@RequestBody DemoUser demoUser) {
		demoUserService.registerUser(demoUser);
	}

	@PutMapping(path = "/{username}")
	public void updateUserProfile(@RequestBody DemoUser demoUser, @PathVariable String username) {
		demoUser.setUsername(username);
		demoUserService.updateUser(demoUser);
	}

	@DeleteMapping(path = "/{username}")
	public void deleteUser(@PathVariable String username) {
		demoUserService.deleteUser(username);
	}
}