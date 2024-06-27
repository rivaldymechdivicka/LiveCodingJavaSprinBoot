package com.example.buyItem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buyItem.models.ItemModel;
import com.example.buyItem.repositories.ItemRepo;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepo itemRepo;

    public List<ItemModel> getAllItems() {
        return itemRepo.findAll();
    }
}
