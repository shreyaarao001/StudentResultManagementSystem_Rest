package com.app.results;


import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import Repository.AdminRepository;
import Repository.StudentRepository;
import entity.*;

/**
 * Root resource (exposed at "adminresource" path)
 */
@Path("adminresource")
public class AdminResource {
//when admin want to add another admin he/she will specify this path
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("add")
    public String AddAdmin(User_Auth user) throws IOException {
    AdminRepository repository=new AdminRepository();
    String password=repository.add(user);
    return password;
    }
	//when admin want to delete another admin he/she will specify this path
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("delete_admin")
    public String deleteAdmin(User_Auth user) throws IOException
    {
		AdminRepository repository=new AdminRepository();
    	String status=repository.deleteAdmin(user);
    	return status;
    }
	//when admin want to add student he/she will specify this path
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("add_student")
    public String AddStudent(Student_Info student_info) throws IOException {
    AdminRepository repository=new AdminRepository();
    System.out.println(student_info.getChemistry());
    String password=repository.addStudent(student_info);
    return password;
    }
	//when admin want to delete student he/she will specify this path
	@POST
  @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("delete_student")
  public String deleteStudent(Student_Info student_info) throws IOException
  {
		AdminRepository repository=new AdminRepository();
		String status=repository.deleteStudent(student_info);
  	return status;
  }
	//when admin want to view all users he/she will specify this apth
	@Path("view_user")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<User_Auth> viewUsers(User_Auth user) {
		ArrayList<User_Auth> result = new AdminRepository().viewUser();
		return result;

	}
	//when admin want to view grades he/she will specify this path
	@Path("view_grades")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Student_Info> viewGrade(Student_Info student_info) {
		ArrayList<Student_Info> result = new AdminRepository().viewGrade(student_info.getGrade());
		return result;

	}
}