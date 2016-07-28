package com.valhallagame.persistantbug;

public class User{

	private String username;

	public User() {	}

	public User(String name) {
		this.setUsername(name);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
