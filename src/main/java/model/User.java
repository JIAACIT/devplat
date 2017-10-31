package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Size(min=2, max=255)
	private String name;

	@NotNull
	@Size(min=2, max=255)
	private String lname;

	@NotNull
	@Min(value = 5)
	@Max(value = 150)
	private int age;
	
	@NotNull
	@Size(min=2, max=255)
	private String pwd;

	@NotNull
	@Size(min=2, max=255)
	private String email;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//constructor vacio
	public User(){}
	
	public User(String name, String lname, String pwd, String email, int age){
		this.name = name;
		this.lname = lname;
		this.age = age;
		this.email = email;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lname=" + lname + ", age=" + age + "]";
	}

}