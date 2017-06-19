package nl.hu.v1ipass.thirdapp.model;

public class Customer {
private int id;
private String name;
private String surname;
private String password;
private String birthday;
private String email;

public Customer(int id, String name, String surname, String password, String birthday, String email) {
	super();
	this.id=id;
	this.name = name;
	this.surname = surname;
	this.password = password;
	this.birthday = birthday;
	this.email = email;
}
public int getId() {
	return id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
public String toString(){
	return id+", "+name+" "+surname;
}
public String getName() {
	return name;
}
public String getSurname() {
	return surname;
}


}
