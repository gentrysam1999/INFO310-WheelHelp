/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebModules;

import DAO.CarDAO;
import DAO.CarJdbcDAO;
import DAO.CustomerDAO;
import DAO.CustomerJdbcDAO;
import DAO.OwnerDAO;
import DAO.OwnerJdbcDAO;
import DAO.TransactionDAO;
import DAO.TransactionJdbcDAO;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.json.Gzon;

/**
 *
 * @author Karl Shipley
 */
public class Server extends Jooby {

    private CarDAO carDao = new CarJdbcDAO();
    private CustomerDAO customerDao = new CustomerJdbcDAO();
    private OwnerDAO ownerDao = new OwnerJdbcDAO();
    private TransactionDAO transactionDao = new TransactionJdbcDAO();

    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");

        Server server = new Server();

        CompletableFuture.runAsync(() -> {
            server.start();
        });

        server.onStarted(() -> {
            System.out.println("\nPress Enter to stop the server.");
        });

        // wait for user to hit the Enter key
        System.in.read();
        System.exit(0);
    }

    public Server() {
        port(8080);
        use(new Gzon());
        use(new OwnerModule(ownerDao));
        use(new CustomerModule(customerDao));
//        use(new SaleModule(saleDao));
        use(new AssetModule());
//

    }
}