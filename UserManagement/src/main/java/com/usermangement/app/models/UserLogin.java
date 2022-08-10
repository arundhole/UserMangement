package com.usermangement.app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="userlogin")
public @Data class UserLogin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int userid;
	
	private String id_address;
	
	private String browser_name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date=new Date();

}
