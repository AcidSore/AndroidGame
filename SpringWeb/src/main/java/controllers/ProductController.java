package controllers;

import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductById(Model uiModel, @RequestParam int id) {
        Product product = productService.getProductById(id);
        return product;
    }
    @RequestMapping(path = "/showProductById/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductById(@PathVariable("sid") int id) {
        Product product = productService.getProductById(id);
        return product;
    }
    @RequestMapping(path = "/showAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> showAllProducts(){
        List<Product> products = productService.getAllProducts();
        return products;
    }

}
