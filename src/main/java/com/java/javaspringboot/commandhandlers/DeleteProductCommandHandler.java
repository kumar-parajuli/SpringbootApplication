package com.java.javaspringboot.commandhandlers;

import com.java.javaspringboot.Exception.ProductNotFoundException;
import com.java.javaspringboot.Repository.Command;
import com.java.javaspringboot.Repository.ProductRepository;
import com.java.javaspringboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductCommandHandler implements Command<Integer, ResponseEntity> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<ResponseEntity> execute(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException();
        }

        Product product =productRepository.findById(id).get();
        productRepository.delete(product);
        return  ResponseEntity.ok().build();
    }
}
