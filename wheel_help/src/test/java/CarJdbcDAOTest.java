

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
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
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
	private CarDAO dao = new CarJdbcDAO("jdbc:h2:~/test;INIT=runscript from 'src/main/java/DAO/schema.sql'");

	private Car car1;

	private Car car2;

	private Car car3;

//	String carName, int carId, String carType, String seatNumber, BigDecimal hourlyCharge, String location) {
	@BeforeEach
	public void setUp() {
		car1 = new Car("W89YO7", "2006 Ford Mondeo", "Hatchnack", "1", new BigDecimal("1.00"), "30 Dundas Street");
		car2 = new Car("Y78Ui9", "2007 Honda Civic", "Hatchback", "1", new BigDecimal("5.00"), "301 Great King Street");
		car3 = new Car("YU8760", "2001 Toyota Prado", "4x4", "1", new BigDecimal("4.00"), "30  duke Street");
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

		assertThat(dao.getCars(), hasItem(car1));
		assertThat(dao.getCars(), hasItem(car2));
		assertThat(dao.getCars(), hasItem(car3));

	}

	@Test
	public void testGetCars() {
		assertThat(dao.getCars(), hasItem(car1));
		assertThat(dao.getCars(), hasItem(car2));
	}

	@Test
	public void testRemoveCar() {
		dao.removeCar(car1);
		assertThat(dao.getCars(), hasSize(1));
		assertThat(dao.getCars(), not(hasItem(car1)));
	}

}
