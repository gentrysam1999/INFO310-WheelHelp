/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebModules;

import DAO.TransactionDAO;
import DAO.TransactionJdbcDAO;
import Domain.Transaction;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author Karl Shipley
 */
public class TransactionModule extends Jooby {

    private TransactionJdbcDAO transactionDao = new TransactionJdbcDAO();
    
   

    public TransactionModule(TransactionDAO transactionDao) {
        post("/api/transactions", (req, rsp) -> {
            Transaction tran = req.body().to(Transaction.class);
            transactionDao.save(tran);
            rsp.status(Status.CREATED);
        });
        
                get("/api/transactions/:ownerId", (req) -> {
            String ownerId = req.param("ownerId").value();
            return transactionDao.getOwnerTransactions(ownerId);
        });  

    }
    
     
 


}