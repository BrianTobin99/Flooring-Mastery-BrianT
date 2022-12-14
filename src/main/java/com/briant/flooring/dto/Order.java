package com.briant.flooring.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Order {
    
    public int order;
    public String customer;
    public String state;
    public String product;
    public BigDecimal area;
    public BigDecimal taxRate;
    public BigDecimal costPerSquare;
    public BigDecimal labPerSquare;
    public BigDecimal matCost;
    public BigDecimal labCost;
    public BigDecimal tax;
    public BigDecimal total;
    public LocalDate date;
    
    public Order(String date, int orderNum, String custName, String state, BigDecimal taxRate, String productType, BigDecimal area, BigDecimal costPer, BigDecimal laborPer, BigDecimal matCost, BigDecimal laborCost, BigDecimal tax, BigDecimal total){
        
        order = orderNum;
        customer = custName;
        this.state = state;
        this.taxRate=taxRate;
        product = productType;
        this.area = area;
        costPerSquare = costPer;
        labPerSquare = laborPer;
        this.matCost = matCost;
        labCost = laborCost;
        this.total = total;
        this.tax=tax;
        this.date = LocalDate.parse(date);
    }
    
}
