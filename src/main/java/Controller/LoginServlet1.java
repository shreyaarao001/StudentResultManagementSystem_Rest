package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import entity.Password;
import entity.Student_Info;

/**
 In this servlet we are going to validate he/she is admin/student ,student get his result and change password 
 */
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Client client = ClientBuilder.newClient(new ClientConfig());
	String apiURL  = "http://localhost:8089/results/webapi";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value=request.getParameter("varname");
		PrintWriter out=response.getWriter();
		/*
		 * In this we will get id,password and give it to repository and validate he/she is admin/student
		 */
		if(value.equals("login")) {
		String id1=request.getParameter("id");
		String password=request.getParameter("password");
		ArrayList<String> list=new ArrayList<>();
		list.add(id1);
		list.add(password);
		WebTarget webTarget = client.target(apiURL).path("myresource/test");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN);
		Response clientResponse = invocationBuilder.post(Entity.entity(list, MediaType.APPLICATION_JSON));
	    String status =clientResponse.readEntity(String.class);
	    //if user is Admin it will redirect to Admin.jsp where admin will can add/delete/view
       if(status.equals("admin")) {
			response.sendRedirect("http://localhost:8089/results/Admin.jsp");
		}
       //if user is student it will directly show his/her result
		else if(status.equals("student"))
		{
			Student_Info student_info = new Student_Info();
			student_info.setId(Integer.parseInt(id1));
			WebTarget webTarget1 = client.target(apiURL).path("studentresource/view_details");
			Invocation.Builder invocationBuilder1 = webTarget1.request(MediaType.APPLICATION_JSON);
			Response clientResponse1 = invocationBuilder1.post(Entity.entity(student_info, MediaType.APPLICATION_JSON));
			GenericType<ArrayList<Student_Info>> gType = new GenericType<ArrayList<Student_Info>>() {};
			ArrayList<Student_Info> list1 = clientResponse1.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("Student.jsp");
			request.setAttribute("view_details", list1);
			dispatch.forward(request, response);
		}
       //if user enter wrong password ,this method will specify as a wrong password
		else if(status.equals("wrong password"))
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.include(request, response);
			out.print("please enter correct password!!");
		}
       //if he/she is not a valid user ,this method will specify as not a valid password
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.include(request, response);
			out.print("you are not valid user!!");
		}
		}
		//if user want to change his/her pasword ,this is used to change password
		else if(value.equals("change")) {
			Password pass=new  Password();
			pass.setId(Integer.parseInt(request.getParameter("id")));
			pass.setPassword(request.getParameter("password"));
			pass.setNewpassword(request.getParameter("newpassword"));
			WebTarget webTarget = client.target(apiURL).path("myresource/change_password");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN);
			Response clientResponse = invocationBuilder.post(Entity.entity(pass, MediaType.APPLICATION_JSON));
		    String status =clientResponse.readEntity(String.class);
		    //if password is changed it will display success message
		    if(status.equals("success")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.include(request, response);
				out.print("Password changed Successfully,Please login with new password!!!!");
	}
		    //if old password and id is not correct,it will specify as enter valid credentails
		    else if(status.equals("fail")) {
		    	RequestDispatcher requestDispatcher= request.getRequestDispatcher("ChangePassword.jsp");
		    	requestDispatcher.include(request, response);
				out.print("enter valid credentials!!");
		    }
		    //if their is any error it will specify  error message
		    else {
		    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		    	requestDispatcher.include(request, response);
				out.print("Error...Please try again!!");
		    }
			
		}
		
	
	
}

}
