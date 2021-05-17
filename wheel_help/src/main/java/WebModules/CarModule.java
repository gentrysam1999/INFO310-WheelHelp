/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebModules;

import DAO.CarDAO;
import DAO.CarJdbcDAO;
import Domain.Car;
import Domain.Customer;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author Karl Shipley
 */
public class CarModule extends Jooby {

    private CarDAO carDao = new CarJdbcDAO();

    public CarModule(CarDAO daoIn) {

        post("/api/cars/register", (req, rsp) -> {
            Car car = req.body().to(Car.class);
            carDao.saveCar(car);
            rsp.status(Status.CREATED);
        });

        get("/api/cars", () -> carDao.getCars());

        get("/api/types", () -> carDao.getTypes());

        get("/api/seatamount", () -> carDao.getSeatNumbers());

        get("/api/types/:type", (req) -> {
            String type = req.param("type").value();
            return carDao.filterByType(type);
        });

        get("/api/seatnumbers/:seatamount", (req) -> {
            String seats = req.param("seatamount").value();
            return carDao.filterBySeatNumber(seats);
        });
//

//   
    }
}
