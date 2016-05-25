/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.base;

/**
 *
 * @author Dima
 */
public class Calc {
    
    /**
     * This method finds the result by formula ((integer/denominator)*divident)
     * @param dividend  Part of the formula
     * @param denominator Part of the formula
     * @param integer Part of the formula
     * @return Result of the formula
     * @throws ArithmeticException 
     */
    
    public static int partOfInteger(int dividend, int denominator, int integer) throws ArithmeticException {
        
        int ret = 0;
        
        if(integer%denominator == 0) {
            int tmp = integer/denominator;
            ret = tmp*dividend;
        } else {
            throw new ArithmeticException("Integer cannot be divided by denominator evenly.");
        }
        
        return ret;
        
    }
    
    public static double getIntegerPartOfDouble(double doubleNum) {
        return getPartOfDouble(true, doubleNum);
    }
    
    public static double getFractionalPartOfDouble(double doubleNum) {
        return getPartOfDouble(false, doubleNum);
    }
    
    private static double getPartOfDouble(boolean Z, double dN) {
        //if(dN%)
        double integer = 0;
        if(dN >= 1000000) {
            //oyy!!!
        } else if(dN >= 1000) {
            //mmm
        } else if(dN >= 100) {
            //easy
        } else if(dN >= 10) {
            //pff
        } else if(dN >= 0) {
            
        }
        return 0;
    }
}
