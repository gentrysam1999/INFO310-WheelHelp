/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Car;

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
public class CarJdbcDAO implements CarDAO {

	private String url = JdbcConnection.getDefaultConnectionUri();

	public CarJdbcDAO() {
	}

	public CarJdbcDAO(String uri) {
		this.url = uri;
	}

	@Override
	public void saveCar(Car car) {
		String sql = "insert into car (car_Name, car_Type, Seat_Number, Hourly_Charge, Location) values (?, ?, ?, ?, ?)";

		try (
			Connection dbCon = JdbcConnection.getConnection(url);
			PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setString(1, car.getCarName());
			//stmt.setInt(2, car.getCarId());
			stmt.setString(2, car.getCarType());
			stmt.setString(3, car.getSeatNumber());
			stmt.setBigDecimal(4, car.getHourlyCharge());
			stmt.setString(5, car.getLocation());

			stmt.executeUpdate();

		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override
	public Collection<Car> getCars() {
		

		String sql = "select * from Car";
		try (
			Connection dbCon = JdbcConnection.getConnection(url); //get connection to db
			PreparedStatement stmt = dbCon.prepareStatement(sql); //create stmt
			) {
			ResultSet rs = stmt.executeQuery(); 

			List<Car> cars = new ArrayList<>(); 

			//iterate through query results
			while (rs.next()) {
				Car car = new Car(
					rs.getString("Car_Name"),
					rs.getInt("Car_Id"),
					rs.getString("Car_Type"),
					rs.getString("Seat_Number"),
					rs.getBigDecimal("Hourly_Charge"),
					rs.getString("Location")
				);

				cars.add(car); 

			}

			return cars;

		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override
	public void removeCar(Car car) {

		String sql = "delete from car where car_ID = ?";

		try (
			Connection dbCon = JdbcConnection.getConnection(url);
			PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setInt(1, car.getCarId()-2);
			stmt.executeUpdate();

		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override

	public Collection<Car> filterByType(String carType) {
		String sql = "select * from car where Type = ?";
		System.out.println(carType);
		try (
			Connection dbCon = JdbcConnection.getConnection(url);
			PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setString(1, carType);
			ResultSet rs = stmt.executeQuery();

			ArrayList<Car> typeList = new ArrayList<>();

			while (rs.next()) {
				Car car = new Car(
					rs.getString("car_Name"),
					rs.getInt("Car_id"),
					rs.getString("car_Type"),
					rs.getString("Seat_Number"),
					rs.getBigDecimal("Hourly_Charge"),
					rs.getString("Location")
				);
				System.out.println(car);
				typeList.add(car);
			}
			return typeList;
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override
	public Collection<Car> filterBySeatNumber(String seatNumber) {
		String sql = "select * from car where Seat_Number = ?";
		System.out.println(seatNumber);
		try (
			Connection dbCon = JdbcConnection.getConnection(url);
			PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setString(1, seatNumber);
			ResultSet rs = stmt.executeQuery();

			ArrayList<Car> seatNumberList = new ArrayList<>();

			while (rs.next()) {
				Car car = new Car(
					rs.getString("car_Name"),
					rs.getInt("Car_id"),
					rs.getString("car_Type"),
					rs.getString("Seat_Number"),
					rs.getBigDecimal("Hourly_Charge"),
					rs.getString("Location")
				);
				System.out.println(car);
				seatNumberList.add(car);
			}
			return seatNumberList;
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		}
	}

}
