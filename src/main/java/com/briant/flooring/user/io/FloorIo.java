package com.briant.flooring.user.io;

import java.math.BigDecimal;
import java.util.List;

/**
 * Input and output.
 */
public interface FloorIo {
    
    // Print string
    public void print(String toPrint);
    
    // Print an entire order.
    public void printOrder(List<String> theOrder);
    
    // Print a list of options, then read the answer.
    public void displayMenu();
    
    // Read in a string.
    public String readIn(String toPrint);
    
    // Read in an Int.
    public int readInt(String toPrint);
    
    // Read in a BigDecimal.
    public BigDecimal readBigDecimal();
    
    public void displayAll(List<String> stringList);
    
    public int displayEditMenu();
    
    public boolean promptDelete(String order);
    
}
