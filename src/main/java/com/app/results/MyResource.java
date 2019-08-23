package com.app.results;

import java.io.IOException;



import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import Repository.*;
import entity.Password;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
   //user/student can be validated using this path
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("test")
    public String LoginValidate(ArrayList<String> list) throws IOException, ServletException{
    LoginRepository repository=new LoginRepository();
    String result=repository.validate(list.get(0),list.get(1));
   return result ;
    }
	//if user want to change password
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("change_password")
	public String Change_Password(Password pass) {
		LoginRepository repository=new LoginRepository();
	    String result=repository.changePass(pass);
	   return result ;
	}
    
	
	
	
	
	
}
