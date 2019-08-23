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

import entity.*;




/**
 * In this servlet admin can add,delete student and admin.Admin can view grdaes and list of users.
 */
public class AdministratorServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Client client = ClientBuilder.newClient(new ClientConfig());
	String apiURL  = "http://localhost:8089/results/webapi/adminresource";
    public AdministratorServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("varname");//get varname from form and check with specified name
		PrintWriter out=response.getWriter();
		//if admin want to add another admin 
		if(option.equals("add")) 
			response.sendRedirect("AddAdmin.jsp");
		else if(option.equals("addadmin")) {
			User_Auth user = new User_Auth();
			user.setId(Integer.parseInt(request.getParameter("id")));
			user.setName(request.getParameter("name"));
			WebTarget webTarget = client.target(apiURL).path("add");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
			String password=clientResponse.readEntity(String.class);
			//if password is generated and admin details are addedit will go inside this block of code
			if (password!=null) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Admin.jsp");
				requestDispatcher.include(request, response);//display password which is randomly generated in order to know to another admin
				out.println("Admin added Successfully........"+"Userid= "+user.getId()+" Name= "+user.getName()+" Password= "+password);
			}
			//if password is not generated it will go in this block of code
			else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddAdmin.jsp");
				requestDispatcher.include(request, response);
				out.print("User addition Unsuccessfully...please try again!");
			}

}
		//if admin want to delete another admin it will go in this block of code
		if(option.equals("deleteadmin")) 
			response.sendRedirect("DeleteAdmin.jsp");
			else if(option.equals("delete_admin")) {
				User_Auth user = new User_Auth();
				user.setId(Integer.parseInt(request.getParameter("id")));
				WebTarget webTarget = client.target(apiURL).path("delete_admin");
				Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
				Response clientResponse = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
				String status=clientResponse.readEntity(String.class);
				//if admin is deleted successfully it will go in this block of code
				if(status.equals("successful")) {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Admin.jsp");
					requestDispatcher.include(request, response);
					out.print("User deleted Successfully!!");
				}//if admin is not deleted it will go in this block of code
				else if (status.equals("unsuccessful")) {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("DeleteAdmin.jsp");
					requestDispatcher.include(request, response);
					out.print("User deletion Unsuccessfully...please try again!");
				}
				//if their is any error while deleting it will to this block of code
				else {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("DeleteAdmin.jsp");
					requestDispatcher.include(request, response);
					out.print("enter valid id!!");
					}
			}
		
		//if admin want to add student it will to this block of code
		if(option.equals("student"))
			response.sendRedirect("AddStudent.jsp");
		else if(option.equals("addstudent")){
			User_Auth user=new User_Auth();
			user.setId(Integer.parseInt(request.getParameter("id")));
			user.setName(request.getParameter("name"));
			Student_Info student_info=new Student_Info();
			student_info.setId(Integer.parseInt(request.getParameter("id")));
			student_info.setMaths(Integer.parseInt(request.getParameter("maths")));
			student_info.setPhysics(Integer.parseInt(request.getParameter("physics")));
			student_info.setChemistry(Integer.parseInt(request.getParameter("chemistry")));
			student_info.setUser_Auth(user);
			WebTarget webTarget = client.target(apiURL).path("add_student");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(student_info, MediaType.APPLICATION_JSON));
			System.out.println(clientResponse.toString());
			String password=clientResponse.readEntity(String.class);
			//if password is radomly generated and details are added it will go to this block of code
			if (password!=null) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Admin.jsp");
				requestDispatcher.include(request, response);//display password which is randomly generated so that student can use this pasword to login
				out.println("User added Successfully........"+"Userid= "+user.getId()+" Name= "+user.getName()+" Password= "+password);
			}
			//if password is not generated or values are not inserted it will go to this block of code
			else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddStudent.jsp");
				requestDispatcher.include(request, response);
				out.print("User addition Unsuccessfully...please try again!");
			}
		
		}
		//if amdin want to delete student
		
		if(option.equals("deleteuser"))
			response.sendRedirect("DeleteStudent.jsp");
		else if(option.equals("delete_student")) {
			Student_Info stud=new Student_Info();
			stud.setId(Integer.parseInt(request.getParameter("id")));
			WebTarget webTarget = client.target(apiURL).path("delete_student");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(stud, MediaType.APPLICATION_JSON));
			String status=clientResponse.readEntity(String.class);
			//values are deleted successfully it will go to this blck of code
			if(status.equals("successful")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Admin.jsp");
				requestDispatcher.include(request, response);
				out.print("User deleted Successfully!!");
			}//if their user is already deleeted 
			else if (status.equals("unsuccessful")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("DeleteStudent.jsp");
				requestDispatcher.include(request, response);
				out.print("User deletion Unsuccessfully...please try again!");
			}
			//their is any error it will display this error message
			else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("DeleteStudent.jsp");
				requestDispatcher.include(request, response);
				out.print("enter valid id!!");
				}
			
		}
		//Admin want to view list of users ,it will go this block of code
		
		if (option.equals("view_user")) {
			WebTarget webTarget = client.target(apiURL).path("view_user");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.get();
			GenericType<ArrayList<User_Auth>> gType = new GenericType<ArrayList<User_Auth>>() {
			};
			
			ArrayList<User_Auth> list = clientResponse.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("ViewUsers.jsp");
			request.setAttribute("user_review", list);
			dispatch.forward(request, response);
		}
		//Admin want to display grades of all students it will this block of code
		 if(option.equals("view_grades")) {
			Student_Info student_info = new Student_Info();
			student_info.setGrade(request.getParameter("grade"));
			WebTarget webTarget = client.target(apiURL).path("view_grades");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(student_info, MediaType.APPLICATION_JSON));
			GenericType<ArrayList<Student_Info>> gType = new GenericType<ArrayList<Student_Info>>() {
			};
			ArrayList<Student_Info> list = clientResponse.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("Grade.jsp");
			request.setAttribute("view_grade", list);
			dispatch.forward(request, response);
		}
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
