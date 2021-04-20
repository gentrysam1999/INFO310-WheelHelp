/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Timestamp;

/**
 *
 * @author boybi215
 */
public class Transaction {
	private int transcactionID;
	private int transactionDate;
	private Timestamp pickupTime;
	private Timestamp dropoffTime;
	
	

	public Transaction() {
	}

	public Transaction(int transcactionID, int transactionDate, Timestamp pickupTime, Timestamp dropoffTime) {
		this.transcactionID = transcactionID;
		this.transactionDate = transactionDate;
		this.pickupTime = pickupTime;
		this.dropoffTime = dropoffTime;
	}

	public int getTranscactionID() {
		return transcactionID;
	}

	public void setTranscactionID(int transcactionID) {
		this.transcactionID = transcactionID;
	}

	public int getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(int transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Timestamp getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Timestamp pickupTime) {
		this.pickupTime = pickupTime;
	}

	public Timestamp getDropoffTime() {
		return dropoffTime;
	}

	public void setDropoffTime(Timestamp dropoffTime) {
		this.dropoffTime = dropoffTime;
	}

	@Override
	public String toString() {
		return "Transaction{" + "transcactionID=" + transcactionID + ", transactionDate=" + transactionDate + ", pickupTime=" + pickupTime + ", dropoffTime=" + dropoffTime + '}';
	}

	
	
}
