package com.java.javaspringboot.controller;

import com.java.javaspringboot.Repository.ProductRepository;
import com.java.javaspringboot.commandhandlers.CreateProductCommandHandlers;
import com.java.javaspringboot.commandhandlers.DeleteProductCommandHandler;
import com.java.javaspringboot.commandhandlers.UpdateProductCommandHandeler;
import com.java.javaspringboot.model.Product;
import com.java.javaspringboot.model.ProductDTO;
import com.java.javaspringboot.model.UpdateProductCommand;
import com.java.javaspringboot.queryhandlers.GetAllProductsQueryHandler;
import com.java.javaspringboot.queryhandlers.GetProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

@Autowired
private ProductRepository productRepository;

@Autowired
private GetAllProductsQueryHandler getAllProductsQueryHandler;
@Autowired
    GetProductQueryHandler getProductQueryHandler;
@Autowired
private CreateProductCommandHandlers createProductCommandHandlers;
    @Autowired
    private UpdateProductCommandHandeler updateProductCommandHandeler;
@Autowired
private DeleteProductCommandHandler deleteProductCommandHandler;

        @GetMapping("/products")
        public ResponseEntity<List<ProductDTO>> getProduct(){
//            return ResponseEntity.ok(productRepository.findAll());
            return  getAllProductsQueryHandler.execute(null);
        }

        @GetMapping("/{id}")
    public ResponseEntity<ProductDTO>getProduct(@PathVariable Integer id){
            return getProductQueryHandler.execute(id);
        }
        @PostMapping("/addProduct")
    public ResponseEntity createProduct(@RequestBody Product product){
//           productRepository.save(product);
//          return ResponseEntity.ok().build();
            createProductCommandHandlers.execute(product);
            return  ResponseEntity.ok().build();
       }

    @PutMapping ("/{id}")
            public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product){
            UpdateProductCommand command= new UpdateProductCommand(id,product);
//            product.setId(id);
//            productRepository.save(product);
//            return  ResponseEntity.ok().build();
        return   updateProductCommandHandeler.execute(command);

    }
    @DeleteMapping("/{id}")
    public  ResponseEntity deleteProduct(@PathVariable Integer id ){
//        product.setId(command.getId());
//        productRepository.save(product);
//        return  ResponseEntity.ok().build();
return deleteProductCommandHandler.execute(id);
    }
}
