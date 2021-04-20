/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author shika823
 */
public class User {
	
	private int userId;
	private String userUsername;
	private String userPassword;
	private String ownerEmail;
	private String userFirstName;
	private String userSurname;
	private String phoneNumber;

	public User() {
	}

	public User(int userId, String userUsername, String userPassword, String ownerEmail, String userFirstName, String userSurname, String phoneNumber) {
		this.userId = userId;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.ownerEmail = ownerEmail;
		this.userFirstName = userFirstName;
		this.userSurname = userSurname;
		this.phoneNumber = phoneNumber;
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User{" + "userId=" + userId + ", userUsername=" + userUsername + ", userPassword=" + userPassword + ", ownerEmail=" + ownerEmail + ", userFirstName=" + userFirstName + ", userSurname=" + userSurname + ", phoneNumber=" + phoneNumber + '}';
	}
	
	
	
	
	
	
	
}
