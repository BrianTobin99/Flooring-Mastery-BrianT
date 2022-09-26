package com.briant.flooring.dto;

import java.math.BigDecimal;

public class Tax {
    
    public String stateAb;
    public String state;
    public BigDecimal tax;
    
    public Tax(String stateAb, String state, BigDecimal tax){
        this.stateAb = stateAb;
        this.state = state;
        this.tax = tax;
    }
    
}
