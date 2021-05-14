/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Car;
import java.util.ArrayList;
import java.util.Collection;
import org.jooby.Route;

/**
 *
 * @author shika823
 */
public interface CarDAO {
	
	public Collection<Car> filterByType(String carType);
	public Collection<Car> filterBySeatNumber(String seatNumber);
	public void saveCar(Car car);
	public Collection<Car> getCars();
         
	
	public void removeCar(Car car);

Collection<String> getTypes();
Collection<String> getSeatNumbers();

	
	
}
