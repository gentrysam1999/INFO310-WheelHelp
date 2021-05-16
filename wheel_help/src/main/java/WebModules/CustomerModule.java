/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebModules;

import DAO.CustomerDAO;
import Domain.Customer;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;

/**
 *
 * @author Karl Shipley
 */
public class CustomerModule extends Jooby {

    public CustomerModule(CustomerDAO customerDAO){
        get("/api/customers/:username", (req) -> {
            String username = req.param("username").value();
            if(customerDAO.getCustomer(username) == null){
                return new Result().status(Status.NOT_FOUND);
            }else{
                return customerDAO.getCustomer(username);
            }
        });
        
        post("/api/customers/register", (req, rsp) -> {
            Customer customer = req.body().to(Customer.class);
            customerDAO.saveCustomer(customer);
            rsp.status(Status.CREATED);
        });
    }
}
