/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.owner;

/**
 *
 * @author Karl Shipley
 */
public interface ownerDAO {
       
    public void saveOwner(owner owner);
    public owner getOwner(String username); 
}
