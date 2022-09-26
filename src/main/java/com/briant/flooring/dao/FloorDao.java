package com.briant.flooring.dao;

import com.briant.flooring.dto.Order;
import com.briant.flooring.dto.Product;
import com.briant.flooring.dto.Tax;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;


public interface FloorDao {
    
    // Create empty hashmaps for orders, taxes, and products.
    HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
    HashMap<String, Tax> taxes = new HashMap<String, Tax>();
    HashMap<String, Product> products = new HashMap<String, Product>();
    
    // Load the input into the empty hashmaps.
    public void load() throws FileNotFoundException;
    
    // Break Down Order String
    public void orderBreakdown(String line, String currentDate);
    
    // Break Down Tax String
    public void taxBreakdown(String line);
    
    // Break Down Product String
    public void productBreakdown(String line);
    
    // Get a specific order by its key
    public Order getOrd(int key);
    
    // Get a specific tax by its key
    public Tax getTax(String key);

    // Get a specific order by its key
    public Product getProduct(String key);
    
    // Create a new order.
    public void newOrder(Order newOrder);
    
    // Return a contains for tax and product as a bool.
    public boolean isValid(String state, String product);
    
    public List<Order> allOrders();
    
    // Export to files
    public void exportFiles();
    
    
    
}
