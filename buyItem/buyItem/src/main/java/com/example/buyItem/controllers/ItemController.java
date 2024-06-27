package com.example.buyItem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.buyItem.models.ItemModel;
import com.example.buyItem.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/")

    public List<ItemModel> getAllItems() {
        return itemService.getAllItems();
    }
}
