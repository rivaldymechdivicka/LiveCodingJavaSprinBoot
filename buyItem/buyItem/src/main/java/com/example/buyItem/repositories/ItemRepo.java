package com.example.buyItem.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buyItem.models.ItemModel;

@Repository
public interface ItemRepo  extends JpaRepository<ItemModel, Long>{
    List<ItemModel> findByName(String name);
}
    

