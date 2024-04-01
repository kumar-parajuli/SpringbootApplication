package com.java.javaspringboot.queryhandlers;

import com.java.javaspringboot.Repository.ProductRepository;
import com.java.javaspringboot.Repository.Query;
import com.java.javaspringboot.model.Product;
import com.java.javaspringboot.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsQueryHandler implements Query<Void, List<ProductDTO>> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<ProductDTO>productDTOS = productRepository
                .findAll()
                .stream()
                .map(ProductDTO::new)
                .toList();
        return ResponseEntity.ok(productDTOS);
    }
}
