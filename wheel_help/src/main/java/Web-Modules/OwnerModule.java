package web;

import DAO.OwnerDAO;
import DAO.OwnerJdbcDAO;
import domain.Owner;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;

/**
 * @author jamespettitt
 */
public class OwnerModule extends Jooby {

    public OwnerModule(OwnerDAO ownerDAO){
        get("/api/owners/:username", (req) -> {
            String username = req.param("username").value();
            if(ownerDAO.getOwner(username) == null){
                return new Result().status(Status.NOT_FOUND);
            }else{
                return ownerDAO.getOwner(username);
            }
        });
        
        post("/api/register", (req, rsp) -> {
            Owner owner = req.body().to(Owner.class);
            ownerDAO.saveOwner(customer);
            rsp.status(Status.CREATED);
        });
    }
}