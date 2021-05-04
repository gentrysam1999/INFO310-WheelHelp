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
	
	private String carName;
	private int carId;
	private String carType;
	private String seatNumber;
	private BigDecimal hourlyCharge;
	private String location;
	//private Collection<String> daysAvailable;

	public Car() {
	}
	
	

	public Car(String carName, String carType, String seatNumber, BigDecimal hourlyCharge, String location) {
            this.carName = carName;
		//this.carId = carId;
		this.carType = carType;
		this.seatNumber = seatNumber;
		this.hourlyCharge = hourlyCharge;
		this.location = location;
		
	}


    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
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
