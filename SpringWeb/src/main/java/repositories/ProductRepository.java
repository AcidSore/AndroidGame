package repositories;

import entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private final List<Product> products = new ArrayList<Product>();

    public Product findById(){
        Product product = new Product();
        product.setId(1);
        product.setTitle("toy1");
        product.setCost(12.99);
        return product;
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public void addProduct(int id, String title, double cost){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setCost(cost);
        products.add(product);
    }
}
