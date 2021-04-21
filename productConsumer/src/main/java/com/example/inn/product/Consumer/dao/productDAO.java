package com.example.inn.product.Consumer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inn.product.Consumer.entity.Product;

@Repository
public interface productDAO extends JpaRepository<Product, Integer> {

}
