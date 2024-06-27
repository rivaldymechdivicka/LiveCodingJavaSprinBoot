package com.example.buyItem.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.buyItem.models.ItemModel;
import com.example.buyItem.repositories.ItemRepo;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public void run(String... args) throws Exception {
        
        ItemModel item1 = new ItemModel();
        item1.setName("Mouse");
        item1.setPrice(12000);

        ItemModel item2 = new ItemModel();
        item2.setName("Mouse");
        item2.setPrice(20000);


        ItemModel item3 = new ItemModel();
        item3.setName("Mouse");
        item3.setPrice(35000);

        ItemModel item4 = new ItemModel();
        item4.setName("keyboard");
        item4.setPrice(12000);

        ItemModel item5 = new ItemModel();
        item5.setName("keyboard");
        item5.setPrice(20000);


        ItemModel item6 = new ItemModel();
        item6.setName("keyboard");
        item6.setPrice(35000);

        itemRepo.save(item1);
        itemRepo.save(item2);
        itemRepo.save(item3);
        itemRepo.save(item4);
        itemRepo.save(item5);
        itemRepo.save(item6);
    }
}

