package com.briant.flooring.dao;

import com.briant.flooring.dto.Order;
import com.briant.flooring.dto.Product;
import com.briant.flooring.dto.Tax;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FloorDaoImpl implements FloorDao {
    int maxOrder;

    public FloorDaoImpl(){
        maxOrder = 0;
    }
    
    @Override
    public void load() throws FileNotFoundException{
        File folder = new File("Orders");
        //System.out.println(folder.getAbsolutePath());
        File[] fileList = folder.listFiles();
        Scanner sc;
        for(File file : fileList){
            sc = new Scanner(new BufferedReader(new FileReader(file)));
            String currentDate = file.getName();
            currentDate = currentDate.substring(11,15) +"-" + currentDate.substring(7,9)+ "-" + currentDate.substring(9,11);
            sc.nextLine();
            while(sc.hasNextLine()){
                orderBreakdown(sc.nextLine(), currentDate);
                maxOrder++;
            }
        }
        sc = new Scanner(new BufferedReader(new FileReader("Data/Taxes.txt")));
        sc.nextLine();
        while(sc.hasNextLine()){
            taxBreakdown(sc.nextLine());
        }
        sc = new Scanner(new BufferedReader(new FileReader("Data/Products.txt")));
        sc.nextLine();
        while(sc.hasNextLine()){
            productBreakdown(sc.nextLine());
        }
        
        
    }

    @Override
    public Order getOrd(int key) {
        return orders.get(key);
    }
    
    public List<Order> allOrders(){
        ArrayList<Order> allOrds = new ArrayList<Order>();
        for(int key : orders.keySet()){
            allOrds.add(orders.get(key));
            maxOrder++;
        }
        return allOrds;
    }

    @Override
    public Tax getTax(String key) {
        return taxes.get(key);
    }

    @Override
    public Product getProduct(String key) {
        return products.get(key);
    }

    @Override
    public void orderBreakdown(String line, String currentDate) {
        List<String> brokenDown = Arrays.asList(line.split(","));
        orders.put(Integer.valueOf(brokenDown.get(0)), new Order(currentDate, Integer.valueOf(brokenDown.get(0)), brokenDown.get(1), 
                brokenDown.get(2), new BigDecimal(brokenDown.get(3)).setScale(2, RoundingMode.HALF_UP), brokenDown.get(4), 
                new BigDecimal(brokenDown.get(5)).setScale(2, RoundingMode.HALF_UP), 
                new BigDecimal(brokenDown.get(6)).setScale(2, RoundingMode.HALF_UP), 
                new BigDecimal(brokenDown.get(7)).setScale(2, RoundingMode.HALF_UP), 
                new BigDecimal(brokenDown.get(8)).setScale(2, RoundingMode.HALF_UP), 
                new BigDecimal(brokenDown.get(9)).setScale(2, RoundingMode.HALF_UP), 
                new BigDecimal(brokenDown.get(10)).setScale(2, RoundingMode.HALF_UP), 
                new BigDecimal(brokenDown.get(11)).setScale(2, RoundingMode.HALF_UP)));
        
    }
    
    public void taxBreakdown(String line){
        List<String> brokenDown = Arrays.asList(line.split(","));
        taxes.put(brokenDown.get(0), new Tax(brokenDown.get(0), brokenDown.get(1), 
            new BigDecimal(brokenDown.get(2)).setScale(2, RoundingMode.HALF_UP)));
    }
    
    public void productBreakdown(String line){
        List<String> brokenDown = Arrays.asList(line.split(","));
        products.put(brokenDown.get(0), new Product(brokenDown.get(0),
            new BigDecimal(brokenDown.get(1)).setScale(2, RoundingMode.HALF_UP),
            new BigDecimal(brokenDown.get(2)).setScale(2, RoundingMode.HALF_UP)));
    }

    @Override
    public void newOrder(Order newOrder) {
        newOrder.order=maxOrder;
        maxOrder++;
        orders.put(newOrder.order, newOrder);
    }

    @Override
    public boolean isValid(String state, String product) {
        return taxes.containsKey(state) && products.containsKey(product);
    }

    @Override
    public void exportFiles(){
        PrintWriter out;
        ArrayList<Order> orderList = new ArrayList<Order>(orders.values());
        ArrayList<String> dates = new ArrayList<String>();
        for(Order o : orderList){
            try {
                if(!dates.contains(o.date.toString())){
                    out = new PrintWriter(new FileWriter("Orders_" + dateToExport(o.date.toString() ) + ".txt"));
                    dates.add(o.date.toString());
                }
                else{
                    out = new PrintWriter(new FileWriter("Orders_" + dateToExport(o.date.toString() ) + ".txt", true));
                }
                out.append(convertToLine(o));
                out.flush();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(FloorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }
    
    public String dateToExport(String date){
        return date.substring(5,7) + date.substring(8) + date.substring(0,4);
    }
    
    public String convertToLine(Order order){
        String answer = String.valueOf(order.order) + "," + order.customer + "," + order.state + "," +
                String.valueOf(order.taxRate) + "," + order.product + "," + String.valueOf(order.area) + "," +
                String.valueOf(order.costPerSquare) + "," + String.valueOf(order.labCost) + "," +
                String.valueOf(order.matCost) + "," + String.valueOf(order.labCost) + "," + 
                String.valueOf(order.tax) + "," + String.valueOf(order.total) + "\n";
        return answer;
    }
}
