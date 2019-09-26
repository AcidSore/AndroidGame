package entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Purchase {
    Session session = null;
    SessionFactory factory = null;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cust_id")
    private int cust_id;

    @Column(name = "prod_id")
    private int prod_id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product", // название таблицы
            joinColumns = @JoinColumn(name = "prod_id"),  // то что связываем
            inverseJoinColumns = @JoinColumn(name = "id") // то на что связываем
    )
    private List<Product> products;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "customer", // название таблицы
            joinColumns = @JoinColumn(name = "cust_id"),  // то что связываем
            inverseJoinColumns = @JoinColumn(name = "id") // то на что связываем
    )
    private List<Customer> customers;

    public Purchase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
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

    public List<Product> getProducts(Customer cust){
        session = getFactory().getCurrentSession();
        session.beginTransaction();
//      тут что-то пошло не так
        products = (List<Product>) session.createQuery("SELECT * FROM `purchase` WHERE `cust_id` = :id", Purchase.class).setParameter(id,cust.getId()).getResultList();


        session.getTransaction().commit();
        session.close();
        getFactory().close();
        factory.close();
    }


}
