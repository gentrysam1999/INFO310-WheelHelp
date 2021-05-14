/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Car;
import Domain.Customer;
import Domain.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author shika823
 */
public class TransactionJdbcDAO implements TransactionDAO {

    private final String url = JdbcConnection.getDefaultConnectionUri();

    @Override
    public void save(Transaction transaction) {

        Connection dbCon = JdbcConnection.getConnection(url);

        try {
            String sql = "insert into Transaction (car_id, customer_id, transaction_date) values (?, ?, ?)";

            try (
                     PreparedStatement insertTransactionStmt = dbCon.prepareStatement(
                            sql, Statement.RETURN_GENERATED_KEYS);  PreparedStatement insertCarPurchaseStmt
                    = dbCon.prepareStatement("insert into Car_Purchase (hours_selected, purchase_price, transaction_id, car_Id) values (?,?,?,?)");) 
                
                    {
			
                    Customer customer = transaction.getCustomer();
                    System.out.println(customer);
                    
                     Car car = transaction.getCar();
                    System.out.println(car);
                    
                    

                    if (transaction.getTransactionDate() == null) {
                        transaction.setTransactionDate(LocalDateTime.now());
                    }
                       LocalDateTime date = transaction.getTransactionDate();
                    Timestamp timestamp = Timestamp.valueOf(date);
                    
                insertTransactionStmt.setString(1, car.getCarId());
                insertTransactionStmt.setInt(2, customer.getcustomerId());
                insertTransactionStmt.setTimestamp(3, timestamp);
                insertTransactionStmt.executeUpdate();
                
                ResultSet rs = insertTransactionStmt.getGeneratedKeys();
                System.out.println(transaction);
                Integer transactionId = null;

                }catch (SQLException ex){
			throw new DAOException(ex.getMessage(), ex);
		}
            }
        }
