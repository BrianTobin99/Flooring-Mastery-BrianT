package com.briant.flooring.user.io;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


public class FloorIoImpl implements FloorIo{
    
    Scanner inputCheck;
    
    public FloorIoImpl(){
        inputCheck = new Scanner(System.in);
    }

    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    @Override
    public void printOrder(List<String> theOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayMenu() {
        System.out.println("################################");
        System.out.println("\tFlooring Program");
        System.out.println("################################");
        System.out.println("1. Display Orders.");
        System.out.println("2. Add an Order.");
        System.out.println("3. Edit an Order.");
        System.out.println("4. Remove an Order.");
        System.out.println("5. Export All Data to Files");
        System.out.println("6. Quit");
        System.out.println("################################");
        
    }

    @Override
    public String readIn(String toPrint) {
        System.out.println(toPrint + "\t");
        return inputCheck.nextLine();
    }

    @Override
    public BigDecimal readBigDecimal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int readInt(String toPrint){
        System.out.println(toPrint + "\t");
        int input = Integer.valueOf(inputCheck.nextLine());
        return input;
    }
    
    public void displayAll(List<String> stringList){
        for (String s : stringList){
            System.out.println(s);
        }
    }

    @Override
    public int displayEditMenu() {
        System.out.println("################################");
        System.out.println("\nWhat would you like to edit?");
        System.out.println("################################");
        System.out.println("1. Customer Name");
        System.out.println("2. State Abbreviation");
        System.out.println("3. Product Type");
        System.out.println("4. Area");
        System.out.println("################################");
        System.out.println();
        return Integer.valueOf(inputCheck.nextLine());
    }
    
    @Override
    public boolean promptDelete(String order){
        System.out.println("Are you sure you would like to remove the following order?");
        System.out.println(order);
        System.out.println("Y/N?");
        if(inputCheck.nextLine().equalsIgnoreCase("Y"))
            return true;
        return false;
    }
}
