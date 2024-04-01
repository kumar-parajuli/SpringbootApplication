package com.java.javaspringboot.Repository;

import org.springframework.http.ResponseEntity;

public interface Command <E,T>{
    ResponseEntity<T> execute(E entity);
}
