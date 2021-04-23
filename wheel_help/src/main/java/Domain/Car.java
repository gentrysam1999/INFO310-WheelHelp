/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author shika823
 */
public class Car { 
	
	
	private int carId;
	private String carType;
	private String seatNumber;
	private BigDecimal hourlyCharge;
	private String location;
	private Collection<String> daysAvailable;

	public Car() {
	}
	
	

	public Car(int carId, String carType, String seatNumber, BigDecimal hourlyCharge, String location, Collection<String> daysAvailble) {
		this.carId = carId;
		this.carType = carType;
		this.seatNumber = seatNumber;
		this.hourlyCharge = hourlyCharge;
		this.location = location;
		this.daysAvailable = daysAvailble;
	}
	
	

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
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

	public Collection<String> getDaysAvailable() {
		return daysAvailable;
	}

	public void setDaysAvailable(Collection<String> daysAvailble) {
		this.daysAvailable = daysAvailble;
	}

	@Override
	public String toString() {
		return "Car{" + "carId=" + carId + ", carType=" + carType + ", seatNumber=" + seatNumber + ", hourlyCharge=" + hourlyCharge + ", location=" + location + ", daysAvailable=" + daysAvailable + '}';
	}
	
	
	
	

}
