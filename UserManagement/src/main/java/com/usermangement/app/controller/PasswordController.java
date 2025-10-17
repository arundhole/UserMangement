package com.usermangement.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermangement.app.models.Password;
import com.usermangement.app.models.User;
import com.usermangement.app.service.PasswordService;
import com.usermangement.app.service.UserService;

@RestController
public class PasswordController 
{
	@Autowired
	private PasswordService pservice;
	
	@Autowired
	private UserService uservice;
	
	 
	
	@PostMapping("/createuser")
	public void createuser(@RequestBody  Map<String,Object> mp)
	{
		User user=new User();
		user.setFname((String) mp.get("fname"));
		user.setLname((String) mp.get("lname"));
		user.setEmail((String)mp.get("email"));
		uservice.creatUser(user);
		Password password=new Password();
		password.setUserid(user.getId());
		password.setPassword((String) mp.get("password"));
		pservice.savePassword(password);
		 
		 
		 
		 
	}
	
	@PostMapping("/updatepassword")
	public void updatepassword(@RequestBody Map<String,Object> mp )
	{
		pservice.updatepassword(mp);
			
	}
	
	
	
	@GetMapping("/login/{user_id}/{password}")
	@ResponseBody 
	public String home(@PathVariable int user_id,@PathVariable String password, HttpServletRequest request)
	{
		if(pservice.login(user_id, password, request))
		{
			
 		return "welcome to home";
 		
		}
		else 
			return "wrong password";
	}
	
	
	@GetMapping("/home")
	public String welcome()
	{
		return "welcome Home.....!";
	}
	 
	

}
