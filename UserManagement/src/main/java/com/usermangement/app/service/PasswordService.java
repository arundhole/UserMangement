package com.usermangement.app.service;

 
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.usermangement.app.models.Password;
import com.usermangement.app.models.User;
import com.usermangement.app.models.UserLogin;
import com.usermangement.app.repository.PasswordRepository;
import com.usermangement.app.repository.UserRepository;
import com.usermangement.app.repository.UserloginRepository;

import eu.bitwalker.useragentutils.UserAgent;
@Configuration
@Service
public class PasswordService extends BCryptPasswordEncoder
{
	@Autowired
	private EmailSenderService ess;
	
	@Autowired
	private PasswordRepository prepository;
	
	@Autowired
	private UserloginRepository urepository;
	
	@Autowired
	private UserRepository userrepository;
	
	PasswordEncoder pencoder=new BCryptPasswordEncoder();
	public void savePassword(Password password)
	{
		
		String encoded=pencoder.encode(password.getPassword());
		password.setPassword(encoded);
 		prepository.save(password);
	}
	
	
	public  Boolean login(int user_id,String password, HttpServletRequest request)
	{
		 
		
		UserLogin userlogin = new UserLogin() ;
		Boolean b=false;
		Password encoded=prepository.findTopByUseridOrderByIdDesc(user_id);
		
		System.out.println(encoded);
		if(pencoder.matches(password,encoded.getPassword()))
			b=true;
		  String ipaddress=(getClientIp(request));
		 UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		 
		 String name= String.valueOf(userAgent);
		System.out.println(  userAgent );
		userlogin.setId_address(ipaddress);
		userlogin.setBrowser_name(name);
		userlogin.setUserid(user_id);
		urepository.save(userlogin);
		System.out.println(name);
		
		
		Optional<User> op  =userrepository.findById(user_id);
		User user=op.get();
		String mail=user.getEmail();
		//ess.sendEmail( mail,"Password updated","new password is  "+password);
		System.out.println(mail);
		System.out.println(password);
	    return b;
	}

	private static String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
	
	 public void updatepassword(Map<String,Object> mp)
	 {
		  
		 String mail=(String) mp.get("email");
		 String pass=(String)mp.get("password");
		 
		  User user  =userrepository.findByEmail(mail);
		 if(user!=null)
		 {
			  Password password=new Password();
			  password.setUserid(user.getId());
			  String encode=pencoder.encode(pass);
			  password.setPassword(encode);
			  prepository.save(password);
			  
			ess.sendEmail( mail,"Password updated", "new password is "+pass);
		 }
		 else
		 {
			 throw new NullPointerException("No such matching email found");
			 
			 
		 }
		
		 
	 }
	
	

}
