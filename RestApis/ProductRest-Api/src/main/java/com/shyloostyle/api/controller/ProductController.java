package com.shyloostyle.api.controller;

import com.shyloostyle.api.dto.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping(value = "/getProduct",produces = "application/json" /*to improve the readability, without it by default SB will consider */)
    public ResponseEntity<Product> getProduct(){
//        this java obj is converting into jason using message converters
//        product obj into product json internally taking care by SB by using message converts
        Product product = new Product(102,"rahul","mishra",131.34);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

//    converting list of objects into json by spring boot using jackson API

    @GetMapping(value = "/products",produces = "application/json")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = new ArrayList<>();
//        or we can create the constructor and then add into list
        productList.add(new Product(1,"honey","bea",20.87));
        productList.add(new Product(2,"Homey","karl",20.87));
        productList.add(new Product(3,"Joney","Gallger",20.87));
        productList.add(new Product(4,"roy","fiona",20.87));
        productList.add(new Product(5,"hon","Lip",20.87));

    return new ResponseEntity<>(productList,HttpStatus.OK);
    }
//getting the products by id using path variable
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
        Product product = new Product(102,"shri","mad",123.87);

        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @PostMapping(value = "/save",consumes = "application/json", produces = "text/plain")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
    System.out.println(product);

        return new ResponseEntity<>("product Saved",HttpStatus.CREATED);
    }
    @PutMapping(value = "/update/{id}",consumes = "application/json",produces = "application/json")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Integer id){
        ResponseEntity<Product> productById = getProductById(id);
        if (productById.getStatusCode() == HttpStatus.OK) {
            Product existingProduct = productById.getBody();
            if (existingProduct != null){
            // Update the existing product with the new product details
             existingProduct.setFirstName(product.getFirstName());
             existingProduct.setLastName(product.getLastName());
             existingProduct.setPrice(product.getPrice());
             saveProduct(existingProduct);
            }
            return new ResponseEntity<>(existingProduct, HttpStatus.OK);
        } else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private void saveProduct(Product existingProduct) {
        System.out.println("product Saved: "+existingProduct);
    }
}
