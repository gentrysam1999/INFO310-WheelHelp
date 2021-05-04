/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author shika823
 */
public class TransactionJdbcDAO implements TransactionDAO{
	
	private final String url = JdbcConnection.getDefaultConnectionUri();

	@Override
	public void save(Transaction transaction) {
	
String sql = "insert into Transaction () values (?, ?, ?, ?, ?, ?)";

		try (
			Connection dbCon = JdbcConnection.getConnection(url); 
			PreparedStatement stmt = dbCon.prepareStatement(sql); 
		){
			

                     
			stmt.executeUpdate();
			
		} catch (SQLException ex){
			throw new DAOException(ex.getMessage(), ex);
		}
    }
}
