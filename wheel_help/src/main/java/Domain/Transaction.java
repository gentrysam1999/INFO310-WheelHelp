/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author boybi215
 */
public class Transaction {

    private int transcactionID;
    private LocalDateTime transactionDate;
    private Car car;
    private Customer customer;

    public Transaction() {
    }

    public Transaction(int transcactionID, LocalDateTime transactionDate, Car car, Customer customer) {
        this.transcactionID = transcactionID;
        this.transactionDate = transactionDate;
        this.car = car;
        this.customer = customer;
    }

    public int getTranscactionID() {
        return transcactionID;
    }

    public void setTranscactionID(int transcactionID) {
        this.transcactionID = transcactionID;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transcactionID=" + transcactionID + ", transactionDate=" + transactionDate + ", car=" + car + ", customer=" + customer + '}';
    }

}
