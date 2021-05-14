/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Car;
import Domain.CarPurchase;
import Domain.Customer;
import Domain.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    = dbCon.prepareStatement("insert into Car_Purchase (hours_selected, purchase_price, transaction_id, car_Id) values (?,?,?,?)");) {

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

                if (rs.next()) {
                    transactionId = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated transaction ID");
                }
                CarPurchase carp = transaction.getCarPurchase();

                insertCarPurchaseStmt.setBigDecimal(1, carp.getHoursSelected());
                insertCarPurchaseStmt.setBigDecimal(2, carp.getPurchasePrice());
                insertCarPurchaseStmt.setInt(3, transactionId);
                insertCarPurchaseStmt.setString(4, carp.getCar().getCarId());
                insertCarPurchaseStmt.executeUpdate();

                dbCon.setAutoCommit(true);
            }
        } catch (SQLException ex) {

            Logger.getLogger(TransactionJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);

            try {
                // something went wrong so rollback
                dbCon.rollback();
                // turn auto-commit back on
                dbCon.setAutoCommit(true);

                // and throw an exception to tell the user something bad happened
                throw new DAOException(ex.getMessage(), ex);
            } catch (SQLException ex1) {
                throw new DAOException(ex1.getMessage(), ex1);
            }

        } finally {
            try {
                dbCon.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransactionJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
