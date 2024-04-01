package com.java.javaspringboot.commandhandlers;

import com.java.javaspringboot.Repository.Command;
import com.java.javaspringboot.Repository.ProductRepository;
import com.java.javaspringboot.model.Product;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductCommandHandlers implements Command<Product, ResponseEntity> {
@Autowired
private ProductRepository productRepository;
    @Override
    public ResponseEntity execute(Product product) {

validateProduct(product);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
    private void  validateProduct(Product product){
        //custom  validate name
        if(StringUtils.isBlank(product.getName())){
            throw new RuntimeException("Product name cannot be empty");
        }

        //custom validate description

        if(StringUtils.isBlank(product.getDescription())){
            throw new RuntimeException("Description cannot be empty");
        }

        //custom validate price with zero or negative

        if(product.getPrice()<=0.0){
            throw new RuntimeException("Price cannot ne negative");
        }

        //custom validate quantity with zero

        if(product.getQuantity()<=0){
            throw  new RuntimeException("Price cannot be negative");
        }
    }
}
