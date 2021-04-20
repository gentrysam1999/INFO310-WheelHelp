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
public class Transaction {
	private int transcactionID;
	private int transactionDate;

	public Transaction() {
	}

	public Transaction(int transcactionID, int transactionDate) {
		this.transcactionID = transcactionID;
		this.transactionDate = transactionDate;
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

	@Override
	public String toString() {
		return "Transaction{" + "transcactionID=" + transcactionID + ", transactionDate=" + transactionDate + '}';
	}
	
	
}
