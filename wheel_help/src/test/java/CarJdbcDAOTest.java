

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.CarDAO;
import DAO.CarJdbcDAO;
import Domain.Car;
import java.math.BigDecimal;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        car1 = new Car();
        car1.setCarId("12412");
        car1.setCarName("Car sokmething");
        car1.setCarType("A type");
        car1.setSeatNumber("1");
        car1.setHourlyCharge(new BigDecimal("4.00"));
        car1.setLocation("30 Duke Street");

        car2 = new Car();
        car2.setCarId("12902");
        car2.setCarName("Car sething");
        car2.setCarType("A tyjksspe");
        car2.setSeatNumber("2");
        car2.setHourlyCharge(new BigDecimal("3.00"));
        car2.setLocation("28 Duke Street");
//        
//        car3 = new Car();
//        car3.setCarId("1862");
//        car3.setCarName("Car setng");
//        car3.setCarType("yjksspe");
//        car3.setSeatNumber("8");
//        car3.setHourlyCharge(new BigDecimal("3.00"));
//        car3.setLocation("98 Duke Street");
        
        
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

        assertThat(dao.getCars(), hasItem(car1));
        assertThat(dao.getCars(), hasItem(car2));
        assertThat(dao.getCars(), hasItem(car3));
        //dao.removeCar(car3);

    }

    @Test
    public void testGetCars() {
        assertThat(dao.getCars(), hasItem(car1));
 
    }

    @Test
    public void testRemoveCar() {
        dao.removeCar(car1);
        assertThat(dao.getCars(), hasSize(1));
        assertThat(dao.getCars(), not(hasItem(car1)));
    }

}
