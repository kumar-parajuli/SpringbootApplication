package com.java.javaspringboot.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Product")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
    private  Integer id;
@Column(name="name")
    private  String name;
@Column(name = "description")
    private String description;
@Column(name="price")
    private  Double price;
@Column(name = "quantity")
    private  Integer quantity;
}
