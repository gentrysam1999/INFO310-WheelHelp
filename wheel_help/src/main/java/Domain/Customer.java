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
public class Customer {
	
	private int customerId;
	private String customerUsername;
	private String customerPassword;
	private String customerEmail;
	private String customerFirstName;
	private String customerSurname;
	private String phoneNumber;

	public Customer() {
	}

	public Customer(int customerId, String customerUsername, String customerPassword, String customerEmail, String customerFirstName, String customerSurname, String phoneNumber) {
		this.customerId = customerId;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.customerEmail = customerEmail;
		this.customerFirstName = customerFirstName;
		this.customerSurname = customerSurname;
		this.phoneNumber = phoneNumber;
	}
	
	

	public int getcustomerId() {
		return customerId;
	}

	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getcustomercustomername() {
		return customerUsername;
	}

	public void setcustomercustomername(String customercustomername) {
		this.customerUsername = customercustomername;
	}

	public String getcustomerPassword() {
		return customerPassword;
	}

	public void setcustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getcustomerEmail() {
		return customerEmail;
	}

	public void setcustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getcustomerFirstName() {
		return customerFirstName;
	}

	public void setcustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getcustomerSurname() {
		return customerSurname;
	}

	public void setcustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "customer{" + "customerId=" + customerId + ", customerUsername=" + customerUsername + ", customerPassword=" + customerPassword + ", customerEmail=" + customerEmail + ", customerFirstName=" + customerFirstName + ", customerSurname=" + customerSurname + ", phoneNumber=" + phoneNumber + '}';
	}
	
	
	
	
	
	
	
}
