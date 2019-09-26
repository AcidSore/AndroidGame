package launcher;

import entities.Customer;
import entities.Product;
import entities.Purchase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Launcher {
    public static void main(String[] args) {
//        Server server = new Server(8080);
//        ProtectionDomain domain = Launcher.class.getProtectionDomain();
//        URL location = domain.getCodeSource().getLocation();
//        WebAppContext webapp = new WebAppContext();
//        webapp.setContextPath("/");
//        webapp.setWar(location.toExternalForm());
//        server.setHandler(webapp);
//        server.start();
//        server.join();


        Session session = null;


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Purchase.class)
                .buildSessionFactory();

        try {
            // CREATE
            session = factory.getCurrentSession();
            Product prod1 = new Product();
            Product prod2 = new Product();
            prod1.setTitle("prod1");
            prod1.setCost(11.99);
            prod2.setCost(12.99);
            Customer customer1 = new Customer();
            Customer customer2 = new Customer();
            customer1.setName("cust1");
            customer1.setName("cust2");
            session.beginTransaction();
            session.save(prod1);
            session.save(prod2);
            session.save(customer1);
            session.save(customer2);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();


        } finally {
            factory.close();
            session.close();
        }




    }
}
