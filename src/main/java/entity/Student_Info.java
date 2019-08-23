package entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student_Info {
@Id
private   int id;
private int maths;
private int physics;
private int chemistry;
private int total;
private String grade;
@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
@JoinColumn(name="name")
private User_Auth user_Auth;

public User_Auth getUser_Auth() {
	return user_Auth;
}
public void setUser_Auth(User_Auth user_Auth) {
	this.user_Auth = user_Auth;
}
public  int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getMaths() {
	return maths;
}
public void setMaths(int maths) {
	this.maths = maths;
}
public int getPhysics() {
	
	return physics;
}
public void setPhysics(int physics) {
	this.physics = physics;
}
public int getChemistry() {
	return chemistry;
}
public void setChemistry(int chemistry) {
	this.chemistry = chemistry;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}

}
