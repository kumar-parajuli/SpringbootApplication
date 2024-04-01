package com.java.javaspringboot.queryhandlers;

import com.java.javaspringboot.Repository.ProductRepository;
import com.java.javaspringboot.Repository.Query;
import com.java.javaspringboot.model.Product;
import com.java.javaspringboot.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductQueryHandler implements Query<Integer, ProductDTO> {
@Autowired
private ProductRepository productRepository;

    @Override
    public ResponseEntity<ProductDTO> execute(Integer id) {
        Optional<Product>product= productRepository.findById(id);
        if(product.isEmpty()){
            throw  new RuntimeException("Product not found");
        }
        return ResponseEntity.ok(new ProductDTO(product.get()));
    }
}
