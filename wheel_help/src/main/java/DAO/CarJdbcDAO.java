/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Car;
import Domain.Owner;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
        String sql = "merge into car (car_id, car_Name, car_Type, Seat_Number, Hourly_Charge, Location, owner_id) values (?, ?, ?, ?, ?, ?, ?)";

        try (
               
                 
                Connection dbCon = JdbcConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, car.getCarId());
            stmt.setString(2, car.getCarName());
            stmt.setString(3, car.getCarType());
            stmt.setString(4, car.getSeatNumber());
            stmt.setBigDecimal(5, car.getHourlyCharge());
            stmt.setString(6, car.getLocation());
            
            //Owner owner = car.getOwner();
            
            stmt.setInt(7, car.getOwnerId());

            
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

            List<Car> carsList = new ArrayList<>();

            //iterate through query results
            while (rs.next()) {

                String carId = rs.getString("Car_Id");
                String carName = rs.getString("Car_Name");

                String carType = rs.getString("Car_Type");
                String seatNumber = rs.getString("Seat_Number");
                BigDecimal hourlyCharge = rs.getBigDecimal("Hourly_Charge");
                String location = rs.getString("Location");
                int ownerId = rs.getInt("owner_id");

                Car car = new Car(carId, carName, carType, seatNumber, hourlyCharge, location, ownerId);

                carsList.add(car);

            }

            return carsList;

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeCar(Car car) {

        String sql = "delete from car where car_ID = ?";

        try (
                 Connection dbCon = JdbcConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, car.getCarId());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<String> getTypes() {
        String sql = "select car_type from car ";

        try (
                 Connection dbCon = JdbcConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            ResultSet rs = stmt.executeQuery();

            Collection<String> typesList = new HashSet<>();

            while (rs.next()) {

                String type = rs.getString("car_type");
                typesList.add(type);
            }

            return typesList;

        } catch (SQLException ex) {

            throw new DAOException(ex.getMessage(), ex);
        }

    }

    @Override

    public Collection<Car> filterByType(String carType) {
        String sql = "select * from car where car_Type = ?";
        System.out.println(carType);
        try (
                 Connection dbCon = JdbcConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, carType);
            ResultSet rs = stmt.executeQuery();

            List<Car> typeList = new ArrayList<>();

            while (rs.next()) {
                Car car = new Car(
                        rs.getString("Car_id"),
                        rs.getString("car_Name"),
                        rs.getString("car_Type"),
                        rs.getString("Seat_Number"),
                        rs.getBigDecimal("Hourly_Charge"),
                        rs.getString("Location"),
                        rs.getInt("Owner_id")
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
    public Collection<String> getSeatNumbers() {
        String sql = "select seat_number from car ";

        try (
                 Connection dbCon = JdbcConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            ResultSet rs = stmt.executeQuery();

            Collection<String> seatNumbers = new HashSet<>();

            while (rs.next()) {

                String seats = rs.getString("seat_number");
                seatNumbers.add(seats);
            }

            return seatNumbers;

        } catch (SQLException ex) {

            throw new DAOException(ex.getMessage(), ex);
        }

    }

    @Override
    public Collection<Car> filterBySeatNumber(String seatNumber) {
        String sql = "select * from car where Seat_Number = ?";
        System.out.println(seatNumber);
        try (
                 Connection dbCon = JdbcConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, seatNumber);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Car> seatNumberList = new ArrayList<>();

            while (rs.next()) {
                Car car = new Car(
                        rs.getString("Car_id"),
                        rs.getString("car_Name"),
                        rs.getString("car_Type"),
                        rs.getString("Seat_Number"),
                        rs.getBigDecimal("Hourly_Charge"),
                        rs.getString("Location"),
                        rs.getInt("Owner_id")
                );
                System.out.println(car);
                seatNumberList.add(car);
            }
            return seatNumberList;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
        @Override
    public Collection<Car> getCarsOwnedBy(String ownerId) {
        String sql = "select * from car where owner_id = ?";
        System.out.println(ownerId);
        try (
                 Connection dbCon = JdbcConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, ownerId);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Car> userCars = new ArrayList<>();

            while (rs.next()) {
                Car car = new Car(
                        rs.getString("Car_id"),
                        rs.getString("car_Name"),
                        rs.getString("car_Type"),
                        rs.getString("Seat_Number"),
                        rs.getBigDecimal("Hourly_Charge"),
                        rs.getString("Location"),
                        rs.getInt("Owner_id")
                );
                System.out.println(car);
                userCars.add(car);
            }
            return userCars;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

}
