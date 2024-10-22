package com.admin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table(name = "ADMIN_DETAILS")
public class Admin {
	
	//Admin attributes
	@Id
	@Positive(message ="Id must be valid")
	private int id;
	
	@Size(min=3, max=20, message="Username size must be b/w 3 to 20")
	private String username;
	
	private String password;
	
	//Getter Setters for Admin attributes.
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
//	//Default constructor.
//	public Admin() {
//		super();
//	}
//	
//	//Parameterized Constructor.
//	public Admin(int id, String username, String email, String password) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.email = email;
//		this.password = password;
//	}

}
