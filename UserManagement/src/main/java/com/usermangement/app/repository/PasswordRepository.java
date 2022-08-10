package com.usermangement.app.repository;
 


import org.springframework.data.jpa.repository.JpaRepository;

import com.usermangement.app.models.Password;

public interface PasswordRepository extends JpaRepository<Password, Integer>{
	
	public Password findBypassword(String password);
	 
	Password findByuseridLike(int user_id);
	
	public  Password findTopByUseridOrderByIdDesc(int user_id);
	
	
	
	 
}
