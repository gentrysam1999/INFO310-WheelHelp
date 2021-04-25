/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Car;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author jamespettitt
 */
public class CarJdbcDAO implements CarDAO{

    
    private String url = DbConnection.getDefaultConnectionUri();
    
    
    public CarJdbcDAO() {
    }
	
    //this may be wrong - check
    public CarJdbcDAO(String uri){
            this.url = uri;
    }
    
    @Override
    public void saveCar(Car car) {
		String sql = "insert into Car (Car_ID, Car_Type, Colour, Seat_Number, Hourly_Charge, Location) values (?, ?, ?, ?, ?, ?)";
		
		try (
			Connection dbCon = DbConnection.getConnection(url);
			PreparedStatement stmt = dbCon.prepareStatement(sql);
		){
                        stmt.setString(1, customer.getCarId());
                        stmt.setString(2, customer.getCarType());
                        stmt.setString(3, customer.getColour());
                        stmt.setString(4, customer.getSeatNumber());
                        stmt.setString(5, customer.getHourlyCharge());
                        stmt.setString(6, customer.getLocation());
                     
			stmt.executeUpdate();
			
		} catch (SQLException ex){
			throw new DAOException(ex.getMessage(), ex);
		}
    }

    @Override
	public void removeCar(Car car) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		String sql = "delete from Car where Car_ID = ?";
		
		try (
			Connection dbCon = DbConnection.getConnection(url);
			PreparedStatement stmt = dbCon.prepareStatement(sql);
		) {
			stmt.setString(1, p1.getCarId());
			stmt.executeUpdate();
			
		} catch (SQLException ex){
			throw new DAOException(ex.getMessage(), ex);
		}
	}

    @Override
	public Collection<Car> filterByType(String type) {
		String sql = "select * from Car where Type = ?";
		System.out.println(type);
		try (
			Connection dbCon = DbConnection.getConnection(url);
			PreparedStatement stmt = dbCon.prepareStatement(sql);
		) {
			stmt.setString(1, type);
			ResultSet rs = stmt.executeQuery();
			
			List<Car> typeList = new ArrayList<>();
			
			while(rs.next()){
				Car car = new Car(rs.getString("Car_ID"), 
														rs.getString("Car_Type"),
														rs.getString("Colour"),
														rs.getString("Seat_Number"),
														rs.getBigDecimal("Hourly_Charge"),
														rs.getBigDecimal("Location")
														);
				System.out.println(car);
				typeList.add(car);
			} 
			return typeList;
		} catch (SQLException ex){
			throw new DAOException(ex.getMessage(), ex);
		}
	}

    @Override
	public Collection<Car> filterBySeatNumber(String number) {
		String sql = "select * from Car where Seat_Number = ?";
		System.out.println(number);
		try (
			Connection dbCon = DbConnection.getConnection(url);
			PreparedStatement stmt = dbCon.prepareStatement(sql);
		) {
			stmt.setString(1, number);
			ResultSet rs = stmt.executeQuery();
			
			List<Car> seatNumberList = new ArrayList<>();
			
			while(rs.next()){
				Car car = new Car(rs.getString("Car_ID"), 
														rs.getString("Car_Type"),
														rs.getString("Colour"),
														rs.getString("Seat_Number"),
														rs.getBigDecimal("Hourly_Charge"),
														rs.getBigDecimal("Location")
														);
				System.out.println(car);
				seatNumberList.add(car);
			} 
			return seatNumberList;
		} catch (SQLException ex){
			throw new DAOException(ex.getMessage(), ex);
		}
	}
    
    
    
}
