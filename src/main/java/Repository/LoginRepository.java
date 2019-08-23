package Repository;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import entity.*;
import serviceimplementation.Validate;
/*
 * This class is used to check he/she is admin/student and we will call this class in rest resource(myesource) 
 * and this class is called when user want to change password in myresource(rest)
 */

public class LoginRepository {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student_Result");
 	EntityManager entityManager = entityManagerFactory.createEntityManager();
 	//validate username and password and check if he/she is studetn/admin based user_type
	public String validate(String id, String password) {
		entityManager.getTransaction().begin();
	 	User_Auth u = entityManager.find(User_Auth.class,Integer.parseInt(id));
	 	String role;
	 	if(u!=null) 
	 	{
	 		if (u.getPassword().equals(password))
	 			{
	 				if(u.getUser_type().equals("admin"))
	 						role="admin";
	 				else 
	 						role="student";
	 			}
	 		else 
	 		{
	 			
	 			role="wrong password";
	 		}
	 	}
	 	else {
	 		
	 		role="no user";
	 	}
	    entityManager.close();
		entityManagerFactory.close();
	    return role;
	}
//change password using id and old password
	public String changePass(Password pass) {
	 	String status="error";
	 	String newpassword=pass.getNewpassword();
		Validate validation=new Validate();
		boolean validPassword=validation.passwordValidation(newpassword);
		System.out.println(validPassword);
		if(validPassword == true) {
			try {
	 	entityManager.getTransaction().begin();
	 	User_Auth u = entityManager.find(User_Auth.class,pass.getId());
	 	if(u.getId()==pass.getId()) 
	 	{
	 		if (u.getPassword().equals(pass.getPassword())) {
	 			u.setPassword(pass.getNewpassword());
	 		   entityManager.persist(u);
	 	       entityManager.getTransaction().commit();
	 	       status="success";
	 		}
	 	       else {
	 	    	   status="fail";
	}
			}
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println(status);
	 	entityManager.close();
		entityManagerFactory.close();
	 	return status;
}
}

