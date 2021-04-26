/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Customer;

/**
 *
 * @author Karl Shipley
 */
public interface customerDAO {
     public Boolean validateCredentials(String username, String password);
    public void saveCustomer(Customer customer);
    public Customer getCustomer(String username);
}
