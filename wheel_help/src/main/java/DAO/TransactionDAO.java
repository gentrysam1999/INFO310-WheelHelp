/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Transaction;
import java.util.Collection;

/**
 *
 * @author shika823
 */
public interface TransactionDAO {
	
		void save(Transaction tran);
                public Collection<Transaction> getOwnerTransactions(String ownerId);
                public Collection<Transaction> getCustomerTransactions(String customerId);
	
}
