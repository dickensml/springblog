package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Product;
import com.example.codeup.springblog.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

//   ------------ dependency injection   ----------------
   private ProductRepository productDao;

    public ProductController(ProductRepository productRepository) {
        this.productDao = productDao;
    }
//   -------get all records with JPA  --------
    @GetMapping("/products")
    public String showAllProducts(Model vModel){
        List<Product> productList = productDao.findAll();
//        pass products to view
        vModel.addAttribute("products", productList);
        return "products/index";


    }
//-----create a record with JPA------
@PostMapping("/products/create")
// Model Attribute is the object that is submitted from the form.
public String submitProduct(@ModelAttribute Product product) {
    productDao.save(product);
    return "redirect:/products";
}

// -----delete a record with JPA --------
@GetMapping("products/delete/test")
    public String deleteProduct(){
        productDao.deleteById(14L);
        return "redirect:/products";
    }

    // -----getting a specific record with JPA --------
    
    @GetMapping("/products/test/{id}")
    public String getProduct(@PathVariable long id) {
        System.out.println(productDao.findById(id).get());
        return "redirect:/products";
    }

}
