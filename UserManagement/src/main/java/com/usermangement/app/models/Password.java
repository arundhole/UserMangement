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
@Table(name="password")
public @Data class Password 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int userid;
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date=new Date();
	

}
