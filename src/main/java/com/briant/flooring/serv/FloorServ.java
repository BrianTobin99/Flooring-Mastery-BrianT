package com.briant.flooring.serv;

import com.briant.flooring.dto.Order;
import java.time.LocalDate;
import java.util.*;


public interface FloorServ {
    
    
    // Get and return all orders.
    public List<String> getAllOrders(LocalDate date);
    
    // Get and return an order
    public String getOneOrder(int orderNum);
    
    public String getOneOrder(Order order);
    
    // Check to see if order has Order Number
    public boolean hasOrderNum(int orderNum);
    
    // Delete order by order number
    public boolean deleteOrder(int orderNum);
    
    // Add an order.
    public void addOrder(Order order);
    
    public Order processOrder(String custName, String state, String productType, String area, String Date);
    
    // Edit an order.
    public boolean editName(int orderNum, String newVal); 
    
    public boolean editState(int orderNum, String newVal);
    
    public boolean editProduct(int orderNum, String newVal);
    
    public boolean editArea(int orderNum, String newVal);
    
    // End
    public void endStep();
    
}
