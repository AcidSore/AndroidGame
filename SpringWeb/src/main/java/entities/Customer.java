package entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    Session session = null;
    SessionFactory factory = null;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer() {
    }

    public SessionFactory getFactory(){
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Purchase.class)
                .buildSessionFactory();
        return factory;
    }


    public void buy(Product prod){
        session = getFactory().getCurrentSession();
        Purchase purchase = new Purchase();
        purchase.setProd_id(prod.getId());
        purchase.setCust_id(this.getId());
        session.beginTransaction();
        session.save(purchase);
        session.getTransaction().commit();
        session.close();
        getFactory().close();
        factory.close();
    }
}
