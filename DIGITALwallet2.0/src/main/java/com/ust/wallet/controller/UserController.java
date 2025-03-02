package com.ust.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.wallet.model.users;
import com.ust.wallet.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	@PostMapping("/register")
	public ResponseEntity<users> register(@RequestBody users user) {
	users u = service.register(user);
	if(u!=null)
		return ResponseEntity.ok(u);
	else
		return new ResponseEntity("Username already exists", HttpStatus.NOT_FOUND);
}
@PostMapping("/login")
public String login(@RequestBody users user) {
	System.out.print(user);
	return service.verify(user);
}
}
