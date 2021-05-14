/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Owner;

/**
 *
 * @author shika823
 */
public interface OwnerDAO {




    public Boolean validateCredentials(String username, String password);
    public void saveOwner(Owner owner);
    public Owner getOwner(String username); 
}


