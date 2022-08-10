package com.usermangement.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermangement.app.models.User;
import com.usermangement.app.service.UserService;

@RestController
public class UserController 
{
	@Autowired
	private UserService uservice;
	
	
//	@PostMapping("/createuser")
//	public void createuser(@RequestBody User user)
//	{
//		uservice.creatUser(user);
//	}

}
