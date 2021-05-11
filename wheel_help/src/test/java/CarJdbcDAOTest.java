

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.CarDAO;
import DAO.CarJdbcDAO;
import Domain.Car;
import java.math.BigDecimal;
import static org.hamcrest.CoreMatchers.hasItem;
//import static org.hamcrest.CoreMatchers.hasItems;
//import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasItems;
//import static org.hamcrest.Matchers.hasItems;
//import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author shika823
 */
public class CarJdbcDAOTest {

    public CarJdbcDAOTest() {
    }

    /**
     *
     * @author shika823
     */
    private CarDAO dao = new CarJdbcDAO("jdbc:h2:mem:test;INIT=runscript from 'src/main/java/DAO/schema.sql'");

    private Car car1;

    private Car car2;

    private Car car3;

//	String carName, int carId, String carType, String seatNumber, BigDecimal hourlyCharge, String location) {
    @BeforeEach
    public void setUp() {
        this.car1 = new Car("0917817", "Car sokmet", "Car smet", "1", new BigDecimal("4.00"), "26 Duke street");

        this.car2 = new Car("00898297", "Car soet", "Caret", "5", new BigDecimal("6.00"), "26 Dundas street");

//        
        this.car3 = new Car("0936297", "Cat", "Caet", "7", new BigDecimal("3.00"), "2226 Dundas street");

        dao.saveCar(car1);
        dao.saveCar(car2);

    }

    @AfterEach
    public void tearDown() {
        dao.removeCar(car1);
        dao.removeCar(car2);
    }

    @Test
    public void testSaveCar() {
        //dao.saveCar(car3);

        assertThat(dao.getCars(), hasItems(car1, car2));

        //dao.removeCar(car3);

    }

    @Test
    public void testGetCars() {
        assertThat(dao.getCars().extracting("carid").contains("0917817", "00898297"));

    }

    @Test
    public void testRemoveCar() {
        dao.removeCar(car1);
        assertThat(dao.getCars(), hasSize(1));
        assertThat(dao.getCars(), not(hasItem(car1)));
    }

}
