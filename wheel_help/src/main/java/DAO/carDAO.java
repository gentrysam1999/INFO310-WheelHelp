/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Car;
import java.util.Collection;

/**
 *
 * @author shika823
 */
public interface carDAO {
	
	Collection<Car> filterByType(String carType);
	
	Collection<Car> filterBySeatNumber(String seatNumber);
	
	//Collection<Car> filterByRating(String carRating);
	
	void saveCar(Car car);
	
	void removeCar(Car car);

	
	
}
