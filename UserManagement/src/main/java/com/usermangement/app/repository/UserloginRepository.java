package com.usermangement.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermangement.app.models.UserLogin;

public interface UserloginRepository extends JpaRepository<UserLogin, Integer>{

}
