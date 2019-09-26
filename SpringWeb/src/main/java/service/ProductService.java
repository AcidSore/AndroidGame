package service;

import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public Product getProductById(int id) {
        Product product = productRepository.findById();
        return product;
    }

    public ProductService() {

    }

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.getAllProducts();
        return products;
    }

    public void addProduct(int id, String title, double price){
        productRepository.addProduct(id, title, price);
    }
}
