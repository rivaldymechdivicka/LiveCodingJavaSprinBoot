package com.example.buyItem.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buyItem.dto.OrderRequest;
import com.example.buyItem.models.ItemModel;
import com.example.buyItem.models.OrderModel;
import com.example.buyItem.repositories.ItemRepo;
import com.example.buyItem.repositories.OrderRepo;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ItemRepo itemRepo;

    public OrderModel createOrder(OrderRequest request) {
        List<ItemModel> searchByNameList = itemRepo.findByName(request.getItemName());
        double moneyOrder = request.getPriceOrder();

        ItemModel selected = null;
        double closestPriceDifference = Double.MAX_VALUE;

        for (ItemModel item : searchByNameList) {
            double priceDifference = Math.abs(item.getPrice() - moneyOrder);
            if (priceDifference < closestPriceDifference && item.getPrice() <= moneyOrder) {
                selected = item;
                closestPriceDifference = priceDifference;
            }
        }
     
        if (selected != null) {
            

            OrderModel order = new OrderModel();
            order.setItemName(selected.getName()); 
            order.setOrderDate(LocalDateTime.now());
            order.setPriceOrder(selected.getPrice());
          
            return orderRepo.save(order);
        } else {
          
            return null; 
        }
    }

    public List<OrderModel> getAllOrders() {
        return orderRepo.findAll();
    }
}