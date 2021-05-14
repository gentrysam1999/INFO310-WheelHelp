/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.math.BigDecimal;

/**
 *
 * @author Karl Shipley
 */
public class CarPurchase {

//    private int carPurchaseId;
    private BigDecimal purchasePrice;

    private BigDecimal hoursSelected;

    private Car car;

//    public int getCarPurchaseId() {
//        return carPurchaseId;
//    }
//
//    public void setCarPurchaseId(int carPurchaseId) {
//        this.carPurchaseId = carPurchaseId;
    //}
    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal PurchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getHoursSelected() {
        return hoursSelected;
    }

    public void setHoursSelected(BigDecimal hoursSelected) {
        this.hoursSelected = hoursSelected;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public BigDecimal getCarTotal() {

        return hoursSelected.multiply(purchasePrice);

    }

    @Override
    public String toString() {
        return "CarPurchase{" + "purchasePrice=" + purchasePrice + ", hoursSelected=" + hoursSelected + ", car=" + car + '}';
    }

    
    
}
