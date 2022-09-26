package com.briant.flooring.core;

import java.time.LocalDate;

import com.briant.flooring.dto.Order;
import com.briant.flooring.user.io.FloorIo;
import com.briant.flooring.serv.FloorServ;

public class Controller {

    FloorIo io;

    FloorServ serv;

    public Controller(FloorIo io, FloorServ serv) {
        this.io = io;
        this.serv = serv;
    }

    
    public void run(){
        int input = 0;
        String textInput = "";
        while(true){
            io.displayMenu();
            input = io.readInt("Pick from the options listed. ");
            if(input == 1){
                try{
                String date = io.readIn("Enter the date in the following format (YYYY-MM-DD)");
                LocalDate lDate = LocalDate.parse(date);
                io.displayAll(serv.getAllOrders(lDate));
                }
                catch(Exception e){
                    System.out.println("The date was entered wrong.");
                }
            }
            if(input == 2){
                String customer = io.readIn("Enter customer name: ");
                String state =  io.readIn("Enter state:");
                String product = io.readIn("Enter product type: ");
                String area = io.readIn("What Area?");
                boolean wrong = false;
                String date;
                do{
                    wrong = false;
                    date = io.readIn("Enter the date in the following format (YYYY-MM-DD): ");
                    if(LocalDate.parse(date).isBefore(LocalDate.now())){
                        wrong=true;
                        io.print("This date has already passed. Try again.");
                    }
                }
                while(wrong);
                Order newOrder = serv.processOrder(customer, state, product, area, date);
                io.print("Would you like to add the following order: Yes or no? ");
                String strInput = io.readIn(serv.getOneOrder(newOrder));
                if(strInput.equalsIgnoreCase("yes")){
                    serv.addOrder(newOrder);
                    io.print("Your order has been added.");
                }
            }
            if(input==3){
                input = io.displayEditMenu();
                if(input == 1){
                    textInput = io.readIn("Enter in a new name: ");
                    input = Integer.valueOf(io.readIn("Enter Order ID: "));
                    if(!serv.editName(input, textInput)){
                        io.print("Please make sure you have the correct order ID.");
                    }
                }
                else if(input == 2){
                    textInput = io.readIn("Enter a State by abbreviation: ");
                    input = io.readInt("Enter Order ID: ");
                    if(!serv.editState(input, textInput)){
                        io.print("Please make sure you have the correct order ID and state abbreviation.");
                    }
                }
                else if(input == 3){
                    textInput = io.readIn("Enter the type of the new product:");
                    input = io.readInt("Enter Order ID: ");
                    if(!serv.editProduct(input, textInput)){
                        io.print("Please make sure you have the correct order ID and product type.");
                    }
                }
                else if(input == 4){
                    textInput = io.readIn("What would you like the new area to be?");
                    textInput = io.readIn("Enter Order ID: ");
                    if(!serv.editArea(input, textInput)){
                        io.print("Please make sure you have the correct order ID and product type.");
                    }
                }
                else{
                    io.print("Your input has not been recognized.");
                }
            }
            if(input == 4){
                input=io.readInt("Enter the Order number for removal: ");
                if(serv.hasOrderNum(input)){
                    if(io.promptDelete(serv.getOneOrder(input)))
                        serv.deleteOrder(input);
                }
                else{
                    io.print("Order not found.");
                }
            }
            if(input == 5){
                serv.endStep();
            }
            if(input == 6){
                return;
            }
        }
    }
    
}
