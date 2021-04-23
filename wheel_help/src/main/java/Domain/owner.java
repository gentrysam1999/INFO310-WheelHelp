/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author boybi215
 */
public class owner {
	private int ownerID;
	private String Username;
	private String Password;
	private String email;

	public owner() {
	}

	public owner(int ownerID, String Username, String Password, String email) {
		this.ownerID = ownerID;
		this.Username = Username;
		this.Password = Password;
		this.email = email;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "owner{" + "ownerID=" + ownerID + ", Username=" + Username + ", Password=" + Password + ", email=" + email + '}';
	}
	
	
	
}
