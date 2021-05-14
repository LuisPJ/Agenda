package com.example.demo.User;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	
	private @Id @GeneratedValue long id;
	private @NotBlank String username;
	private @NotBlank String password;
	private @NotBlank boolean loggedIn;

	public User() {
		
	}
	
	public User(@NotBlank String username, @NotBlank String password) {
		this.username = username;
		this.password = password;
		this.loggedIn = false;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * @param loggedIn the loggedIn to set
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	//Esto se utilizará más adelante cuando queramos comparar un objeto pasado al programa con un objeto de nuestra base de datos.
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof User)) return false;
		User user = (User) o;
		return Objects.equals(username, user.username) && Objects.equals(password, user.password);
	}
	
	//Esta función se utiliza para generar un valor hash de nuestro objeto.
	@Override
	public int hashCode() {
		return  Objects.hash(id, username, password, loggedIn);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", loggedIn=" + loggedIn + "]";
	}
	
	
	
}
