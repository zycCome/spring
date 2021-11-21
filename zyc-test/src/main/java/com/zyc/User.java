package com.zyc;

/**
 * @author zhuyc
 * @date 2021/11/15 22:38
 **/
public class User {
	private String username;
	private String address;

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		System.out.println("create User");
	}
}
