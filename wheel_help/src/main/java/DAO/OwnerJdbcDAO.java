/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Sam Gentry
 */
import Domain.Owner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerJdbcDAO implements ownerDAO {

    private String url = JdbcConnection.getDefaultConnectionUri();

    public OwnerJdbcDAO() {
    }

    //this may be wrong - check
    public OwnerJdbcDAO(String uri) {
        this.url = uri;
    }

    @Override
    public void saveOwner(Owner owner) {

        String sql = "insert into Owner (OwnerID, String Username, String Password, String email) values (?, ?, ?, ?)";

        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            stmt.setInt(1, owner.getOwnerID());
            stmt.setString(2, owner.getUsername());
            stmt.setString(3, owner.getPassword());
            stmt.setString(4, owner.getEmail());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Owner getOwner(String username) {

        String sql = "SELECT * FROM OWNER where Username = ?";

        try (
                Connection dbCon = JdbcConnection.getConnection(url); 
                PreparedStatement stmt = dbCon.prepareStatement(sql); 
                ) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int ownerID = rs.getInt("Owner_ID");
                String ownerUsername = rs.getString("Username");
                String password = rs.getString("Password");
                String emailAddress = rs.getString("Email");

                return new Owner(ownerID, ownerUsername, password, emailAddress);

            } else {
                return null;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Boolean validateCredentials(String username, String password) {
        String sql = "SELECT * FROM Owner where Username = ? and Password = ?";
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
