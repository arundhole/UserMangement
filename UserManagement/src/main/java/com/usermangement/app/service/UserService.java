package com.usermangement.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermangement.app.models.User;
import com.usermangement.app.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository urepository;
	
	public void creatUser(User user)
	{
		urepository.save(user);
	}

}
