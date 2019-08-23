package Repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.*;
import serviceimplementation.*;


/*
 * This class is like dao where we can insert,update,delete and view and we will this class in rest resource(adminresource)
 */
public class AdminRepository {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student_Result");
 	EntityManager entityManager = entityManagerFactory.createEntityManager();
 	//if admin want to add another admin it will go inside this method 
	public String add(User_Auth user) {
		String password=null;
		try {
		entityManager.getTransaction().begin();
	 	password=Validate.generatePassword();
	 	user.setPassword(password);
	 	user.setUser_type("admin");
	 	entityManager.persist(user);
	 	 entityManager.getTransaction().commit();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
	        entityManager.close();
	        entityManagerFactory.close();
		}
	 	return password;
		
	}
	//if admin want to delete another admin it will go through this method
	public String deleteAdmin(User_Auth user) {
		String status="Unsuccessful";
		try {
			User_Auth admin = entityManager.find(User_Auth.class,user.getId());
			if(admin.getUser_type().equals("admin")) {
			entityManager.getTransaction().begin();
			entityManager.remove(admin);
			entityManager.getTransaction().commit();
			status="successful";
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
	        entityManager.close();
	        entityManagerFactory.close();
		}
		return status;
	}
	//if admin want to add another student it will to through this method
	public String addStudent(Student_Info student_info) {
		String password=null;
		try {
		entityManager.getTransaction().begin();
	 	password=Validate.generatePassword();
	 	User_Auth user=student_info.getUser_Auth();
	 	user.setId(student_info.getId());
	 	user.setPassword(password);
	 	user.setUser_type("student");
	    student_info.setUser_Auth(user);
		int total=Calculate.getTotal(student_info);
		String grade=Calculate.getGrade(total);
		student_info.setTotal(total);
		student_info.setGrade(grade);
		entityManager.persist(user);
		entityManager.persist(student_info);
		entityManager.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
	        entityManager.close();
	        entityManagerFactory.close();
		}
	 	return password;
	}
	//if admin want to delete any student it will go through this method
	public String deleteStudent(Student_Info student_info) {
		String status = "error";
		try {
			
			student_info = entityManager.find(Student_Info.class, student_info.getId());
			User_Auth user = entityManager.find(User_Auth.class, student_info.getId());
			if (user.getUser_type().equals("student")) {
				entityManager.getTransaction().begin();
				entityManager.remove(user);
				entityManager.remove(student_info);
				entityManager.getTransaction().commit();
				status = "successful";
				
			}
			else {
				status="unsuccesful";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
	        entityManager.close();
	        entityManagerFactory.close();
		}
		return status;
	}
	//if admin want to view all users it will through this method
	public ArrayList<User_Auth> viewUser() {
		entityManager.getTransaction().begin();
		TypedQuery<User_Auth> query = entityManager.createQuery("SELECT c FROM User_Auth c",User_Auth.class);
		ArrayList<User_Auth> results = (ArrayList<User_Auth>)query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return results;
	}
	//if admin want to view all grades of student it will through this method
	public ArrayList<Student_Info> viewGrade(String grade) {
		entityManager.getTransaction().begin();
		TypedQuery<Student_Info> query = entityManager.createQuery("SELECT c FROM Student_Info c where c.grade=:grade",Student_Info.class);
		query.setParameter("grade",grade);
		ArrayList<Student_Info> results = (ArrayList<Student_Info>)query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return results;
	}

}
