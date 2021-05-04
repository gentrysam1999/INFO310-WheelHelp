/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.CarJdbcDAO;
import DAO.carDAO;
import Domain.Car;
import java.math.BigDecimal;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.Assertions;
/**
 *
 * @author shika823
 */
public class JDBCDAOTest {
	
	private carDAO dao = new CarJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/schema.sql'");
	
	private  Car car1;
	
	private Car car2;
	
	private Car car3;
	
//	String carName, int carId, String carType, String seatNumber, BigDecimal hourlyCharge, String location) {
	
	@BeforeEach
   public void setUp() {
		car1 = new Car("2006 Ford Mondeo", "Hatchnack", "1", new BigDecimal("1.00"), "30 Dundas Street");
		car2 = new Car("2007 Honda Civic", "Hatchback", "1", new BigDecimal("5.00"), "301 Great King Street");
		car3 = new Car("2001 Toyota Prado", "4x4", "1", new BigDecimal("4.00"), "30  duke Street");
		
	}
	
	}
	

