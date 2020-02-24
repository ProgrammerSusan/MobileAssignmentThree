package com.example.app3;
import android.graphics.Color;
import android.widget.*;

import java.lang.Math;

public class RetirementCalculator {

    //method to calculate retirement
    public int[] calculateRetirement(float currentPrincipal, float annualAddition, float rate,  int years){
        int [] retirement = new int [years];
        for(int i = 0; i < retirement.length; i++){
            float input = (currentPrincipal + 100 * annualAddition/rate) * (float)Math.pow(1 + rate/100, i) - 100 * (annualAddition/rate);
            retirement[i] = Math.round(input);
        }
        return retirement;
    }
}
