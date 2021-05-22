/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 *
 * @author boybi215
 */
public class Transaction {

    private int transactionID;
    private int ownerId;
     private String customerUsername;
//    private int customerId;
    private Timestamp date;
    private BigDecimal total;
    private LocalDateTime transactionDate;
    private Car car;
    private Customer customer;
    private Transaction transaction;
    private CarPurchase carpurchase;
   

    private Collection<CarPurchase> items;

    public Transaction() {
    }

    public Transaction(int transactionID, int ownerId, String customerUsername, Timestamp date, BigDecimal total) {
        this.transactionID = transactionID;
        this.ownerId = ownerId;
        this.customerUsername = customerUsername;
        this.date = date;
        this.total = total;
    }


    

//    public Transaction(int transactionID, LocalDateTime transactionDate, Car car, Customer customer, CarPurchase carpurchase) {
//        this.transactionID = transactionID;
//        this.transactionDate = transactionDate;
//        this.car = car;
//        this.customer = customer;
//        this.carpurchase = carpurchase;
//    }
//    public Transaction(int transactionID, int ownerId, int customerId, Timestamp date, BigDecimal total) {
//        this.transactionID = transactionID;
//        this.ownerId = ownerId;
//        this.customerId = customerId;
//        this.date = date;
//        this.total = total;
//    }

    public int getTranscactionID() {
        return transactionID;
    }

    public void setTranscactionID(int transcactionID) {
        this.transactionID = transcactionID;
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

    public CarPurchase getCarPurchase() {
        return carpurchase;
    }

    public void setCarPurchase(CarPurchase carpurchase) {
        this.carpurchase = carpurchase;
    }

    public Collection<CarPurchase> getItems() {
        return items;
    }

    public void setItems(Collection<CarPurchase> items) {
        this.items = items;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }
    
    

//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public CarPurchase getCarpurchase() {
        return carpurchase;
    }

    public void setCarpurchase(CarPurchase carpurchase) {
        this.carpurchase = carpurchase;
    }

    public BigDecimal getTotal() {

        BigDecimal total = BigDecimal.ZERO;

        for (CarPurchase item : items) {
            total = total.add(item.getCarTotal());
        }

        return total;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transcactionID=" + transactionID + ", transactionDate=" + transactionDate + ", car=" + car + ", customer=" + customer + '}';
    }

}
