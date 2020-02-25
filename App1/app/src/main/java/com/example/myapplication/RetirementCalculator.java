package com.example.myapplication;

import java.lang.Math;

public class RetirementCalculator {
    private float currentPrincipal;
    private float annualAddition;
    private float rate;
    private int years;

    public RetirementCalculator(float currentPrincipal, float annualAddition, float rate, int years){
        this.currentPrincipal = currentPrincipal;
        this.annualAddition = annualAddition;
        this.rate = rate;
        this.years = years;
    }

    //method to calculate retirement
    public int[] calculateRetirement(){
        int [] retirement = new int [years];
        for(int i = 0; i < retirement.length; i++){
            float input = (currentPrincipal + 100 * annualAddition/rate) * (float)Math.pow(1 + rate/100, i) - 100 * (annualAddition/rate);
            retirement[i] = Math.round(input);
        }
        return retirement;
    }
}
