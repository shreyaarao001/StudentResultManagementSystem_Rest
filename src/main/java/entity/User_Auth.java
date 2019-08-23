package entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_Auth {
@Id
private int id;
private String name;
private String password;
private String user_type;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public User_Auth(int id, String password, String user_type) {
	this.id=id;
	this.password=password;
	this.user_type=user_type;
	
}
public User_Auth() {
	
}
@Override
public String toString() {
	return "User_Auth [id=" + id + ", password=" + password + ", user_type=" + user_type + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUser_type() {
	return user_type;
}
public String setUser_type(String user_type) {
	return this.user_type = user_type;
}

}

