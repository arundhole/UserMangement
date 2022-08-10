package com.usermangement.app.repository;

 
import org.springframework.data.jpa.repository.JpaRepository;

 
import com.usermangement.app.models.User;

public interface UserRepository extends JpaRepository<User, Integer> 
{
	User findByEmail(String emial);
	 
}
