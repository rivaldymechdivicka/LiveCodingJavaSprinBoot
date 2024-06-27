package com.example.buyItem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buyItem.models.OrderModel;

@Repository
public interface OrderRepo extends JpaRepository<OrderModel, Long>{
    
}
