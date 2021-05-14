package WebModules;

import DAO.OwnerDAO;
import Domain.Owner;
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
            ownerDAO.saveOwner(owner);
            rsp.status(Status.CREATED);
        });
    }
}