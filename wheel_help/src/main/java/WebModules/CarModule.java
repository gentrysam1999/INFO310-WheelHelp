/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebModules;

import DAO.CarDAO;
import DAO.CarJdbcDAO;
import org.jooby.Jooby;

/**
 *
 * @author Karl Shipley
 */
public class CarModule  extends Jooby {

    private CarDAO carDao = new CarJdbcDAO();

    public CarModule(CarDAO daoIn) {

        get("/api/cars", () -> carDao.getCars());

        get("/api/types", () -> carDao.getTypes());

        get("/api/types/:type", (req) -> {
            String type = req.param("type").value();
            return carDao.filterByType(type);
        });
//
//        get("/api/products/:id", (req) -> {
//            String id = req.param("id").value();
//            return productDao.searchById(id);
//        });
//   
    }
}