

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.CarDAO;
import DAO.CarJdbcDAO;
import Domain.Car;
import java.math.BigDecimal;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.hasItems;
//import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
//import static org.hamcrest.Matchers.hasItems;
//import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        this.car1 = new Car("0917817", "Car sokmet", "suv", "1", new BigDecimal("4.00"), "26 Duke street");

        this.car2 = new Car("00898297", "Car soet", "4wd", "5", new BigDecimal("6.00"), "26 Dundas street");

//        
        this.car3 = new Car("0936297", "Cat", "Caet", "4", new BigDecimal("3.00"), "2226 Dundas street");

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
        dao.saveCar(car3);

        assertThat(dao.getCars(), hasItems(car1, car2, car3));

        dao.removeCar(car3);

    }

    @Test
    public void testGetCars() {
        assertThat(dao.getCars(), hasItems(car1, car2));

    }

    @Test
    public void testRemoveCar() {
        dao.removeCar(car1);
        assertThat(dao.getCars(), hasSize(1));
        assertThat(dao.getCars(), not(hasItem(car1)));
    }
    
        @Test
    public void testGetTypes() {
        assertEquals(car1.getCarType(), ("suv"));
        assertEquals(car2.getCarType(), ("4wd"));
        assertThat(dao.getTypes(), hasSize(2));
        assertThat(dao.getTypes(), contains("4wd", "suv"));
    }

    
    @Test
    public void testFilterByCarType() {
        Collection<Car> filterType = dao.filterByType("4wd");

        for (Car car : filterType) {

            String type = car.getCarType();
            assertThat(car.getCarType(), is("4wd"));

            assertThat(car.getCarType(), is(not("suv")));

        }

    }
    
            @Test
    public void testSeatNumbers() {
        assertEquals(car1.getSeatNumber(), ("1"));
        assertEquals(car2.getSeatNumber(), ("5"));
        assertThat(dao.getSeatNumbers(), hasSize(2));
        assertThat(dao.getSeatNumbers(), contains("1", "5"));
    }

    
    @Test
    public void testFilterBySeatNumbers() {
        Collection<Car> filterSeats = dao.filterBySeatNumber("1");

        for (Car car : filterSeats) {

            String seats = car.getSeatNumber();
            assertThat(car.getSeatNumber(), is(seats));

            assertThat(car.getCarType(), is(not("5")));

        }

    }

}
