package com.harrisoncook.TaxInfo;

/**
 * CalculateTax
 *
 * This class is used to calculate the amount of tax owed.
 *
 * @author Harrison Cook
 * */

public class CalculateTax {

    private String type;
    private double income;
    private double[] percentages = {0.1, 0.12, 0.22, 0.24,0.32,0.35,0.37};

    public CalculateTax(String type, double income){
        this.type = type;
        this.income = income;
    }

    public double getRange(){

        double[] incomeRange = new double[6];
        if(type.equals("Single")){
            double[] temp = {9700, 39475,84200,160725,204100,510300};
            System.arraycopy(temp,0,incomeRange,0,6);
        }
        else if(type.equals("Married Filing Jointly")){
            double[] temp = {19400, 78950,168400,321450,408200,612350};
            System.arraycopy(temp,0,incomeRange,0,6);
        }
        else{
            double[] temp = {13850, 52850,84200,160700,204100,510300};
            System.arraycopy(temp,0,incomeRange,0,6);
        }
        return getTaxOwed(incomeRange);
    }

    private double getTaxOwed(double[] ranges){
        int  i = 0;
        double taxOwed = 0;
        double tempIncome=income;
        do{
            if (i+1>=percentages.length){
                taxOwed+=tempIncome*percentages[percentages.length-1];
                break;
            }
            if(income>=ranges[i]){
                if(i==0){
                    taxOwed += ranges[i]*percentages[i];
                }
                else {
                    taxOwed += (ranges[i] - ranges[i - 1]) * percentages[i];
                }
            }
            else{
                taxOwed+=tempIncome*percentages[i];
            }
            tempIncome=income-ranges[i];

        }while(income>ranges[i++]);
        return taxOwed;
    }
}
