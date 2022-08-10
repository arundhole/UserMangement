package com.usermangement.app.dto;

import javax.validation.constraints.NotNull;

 

import lombok.Data;

@Data

public class LoginDTO {
	@NotNull
	String username;
	@NotNull
	String password;
}
