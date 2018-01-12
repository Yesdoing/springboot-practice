package net.yesdoing.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User extends AbstractEntity {
	
	@Column(nullable=false, length=20, unique=true)
	@JsonProperty
	private String userId;
	@JsonIgnore
	private String password;
	@JsonProperty
	private String name;
	@JsonProperty
	private String email;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public boolean matchPassword(String password) {
		if(password == null) {
			return false;
		}
		
		return password.equals(this.password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void update(User newUser) {
		this.userId = newUser.userId;
		this.name = newUser.name;
		this.email = newUser.email;
	}


	public boolean matchId(Long id) {
		if(id == null) {
			return false;
		}
		return id.equals(super.getId());
	}
	
	@Override
	public String toString() {
		return "User [id=" + getId() + ", userId=" + userId + ", password=" + password + ", name=" + name + ", email="
				+ email + "]";
	}
	

	
}
