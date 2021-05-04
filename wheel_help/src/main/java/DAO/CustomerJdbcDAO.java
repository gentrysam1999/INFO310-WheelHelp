/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Karl Shipley
 */
import Domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerJdbcDAO implements CustomerDAO {

    private String url = JdbcConnection.getDefaultConnectionUri();

    public CustomerJdbcDAO() {
    }

    //this may be wrong - check
    public CustomerJdbcDAO(String uri) {
        this.url = uri;
    }

    @Override
    public void saveCustomer(Customer customer) {

        String sql = "insert into Customer (Username, password,  EmailAddress, first_name, last_name, phone) values (?, ?, ?, ?, ?, ?)";

        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            stmt.setString(1, customer.getcustomerUsername());
            stmt.setString(2, customer.getcustomerPassword());
            stmt.setString(3, customer.getcustomerEmail());
            stmt.setString(4, customer.getcustomerFirstName());
            stmt.setString(5, customer.getcustomerSurname());
            stmt.setString(6, customer.getPhoneNumber());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Customer getCustomer(String username) {

        String sql = "SELECT * FROM CUSTOMER where Username = ?";

        try (
                Connection dbCon = JdbcConnection.getConnection(url); 
                PreparedStatement stmt = dbCon.prepareStatement(sql); 
                ) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int customerID = rs.getInt("Customer_ID");
                String customerUsername = rs.getString("Username");
                String password = rs.getString("Password");
                String emailAddress = rs.getString("EmailAddress");
                String firstName = rs.getString("First_Name");
                String surname = rs.getString("Surname");
                String phone = rs.getString("Phone");

                return new Customer(customerID, customerUsername, firstName, surname, password, emailAddress, phone);

            } else {
                return null;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Boolean validateCredentials(String username, String password) {
        String sql = "SELECT * FROM CUSTOMER where Username = ? and Password = ?";
        try (
                Connection dbCon = JdbcConnection.getConnection(url); 
                PreparedStatement stmt = dbCon.prepareStatement(sql); 
                ) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

}
