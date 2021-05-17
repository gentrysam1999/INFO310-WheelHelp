/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author shika823
 */
public class Car {

    private String carName;
    private String carId;
    private String carType;
    private String seatNumber;
    private BigDecimal hourlyCharge;
    private String location;

    private Owner owner;
    //private Collection<String> daysAvailable;

    public Car() {
    }

    public Car(String carId, String carName, String carType, String seatNumber, BigDecimal hourlyCharge, String location) {

        this.carId = carId;
        this.carName = carName;
        this.carType = carType;
        this.seatNumber = seatNumber;
        this.hourlyCharge = hourlyCharge;
        this.location = location;

    }

    public Car(String carName, String carType, String seatNumber, BigDecimal hourlyCharge, String location) {
        this.carName = carName;
        this.carType = carType;
        this.seatNumber = seatNumber;
        this.hourlyCharge = hourlyCharge;
        this.location = location;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (!Objects.equals(this.carId, other.carId)) {
            return false;
        }
        return true;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BigDecimal getHourlyCharge() {
        return hourlyCharge;
    }

    public void setHourlyCharge(BigDecimal hourlyCharge) {
        this.hourlyCharge = hourlyCharge;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /*
	public Collection<String> getDaysAvailable() {
		return daysAvailable;
	}

	public void setDaysAvailable(Collection<String> daysAvailble) {
		this.daysAvailable = daysAvailble;
	}
     */

    @Override
    public String toString() {
        return "Car{" + "carName=" + carName + ", carId=" + carId + ", carType=" + carType + ", seatNumber=" + seatNumber + ", hourlyCharge=" + hourlyCharge + ", location=" + location + '}';
    }

}
