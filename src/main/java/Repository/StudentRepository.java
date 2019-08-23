package Repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Student_Info;
/*
 * This class is like dao it will view result of student when he/she clicks login button and we will call this class in 
 * studentresource
 */


public class StudentRepository {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student_Result");
 	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public ArrayList<Student_Info> viewDetails(Student_Info student_info) {
		entityManager.getTransaction().begin();
		TypedQuery<Student_Info> query = entityManager.createQuery("SELECT c FROM Student_Info c where id=:id",Student_Info.class);
		query.setParameter("id",student_info.getId());
		ArrayList<Student_Info> results = (ArrayList<Student_Info>)query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return results;
		
	}

}
