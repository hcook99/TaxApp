package com.harrisoncook.TaxInfo;

/**
 * Info
 *
 * This class is used to store the type of situation a person is in be it married, single, head of household.
 *
 * @author Harrison Cook
 * */

public class Info {

    private double income;
    private String types;

    public String getTypes(){
        return types;
    }

    public void setTypes(String types){
        this.types = types;
    }

    public double getIncome(){
        return income;
    }

    public void setIncome(double income){
        this.income = income;
    }

}
