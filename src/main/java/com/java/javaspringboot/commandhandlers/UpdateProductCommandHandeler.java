package com.java.javaspringboot.commandhandlers;

import com.java.javaspringboot.Repository.Command;
import com.java.javaspringboot.Repository.ProductRepository;
import com.java.javaspringboot.model.Product;
import com.java.javaspringboot.model.UpdateProductCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductCommandHandeler implements Command<UpdateProductCommand, ResponseEntity> {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public ResponseEntity<ResponseEntity> execute(UpdateProductCommand command) {
        Product product =command.getProduct();
        product.setId(command.getId());
        productRepository.save(product);
        return  ResponseEntity.ok().build();
    }
}
