/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.generation;

import ru.epiclib.base.Base;

/**
 * 
 * @author Dima
 */
public final class Gen {
    
    private final int lenght;
    
    private final boolean hasSmall,hasBig,hasNumbers,hasSymbols;

    public Gen(int lenght, boolean hasSmall, boolean hasBig, boolean hasNumbers, boolean hasSymbols) {
        this.lenght = lenght;
        this.hasSmall = hasSmall;
        this.hasBig = hasBig;
        this.hasNumbers = hasNumbers;
        this.hasSymbols = hasSymbols;
    }
    
    public Gen(int lenghtFrom,int lenghtTo, boolean hasSmall, boolean hasBig, boolean hasNumbers, boolean hasSymbols) {
        this.lenght = Base.randomNumber(lenghtFrom, lenghtTo);
        this.hasSmall = hasSmall;
        this.hasBig = hasBig;
        this.hasNumbers = hasNumbers;
        this.hasSymbols = hasSymbols;
    }
    
    private String getType() {
        String type = "";
        type += Base.getBinaryOfBoolean(hasSmall);
        type += Base.getBinaryOfBoolean(hasBig);
        type += Base.getBinaryOfBoolean(hasNumbers);
        type += Base.getBinaryOfBoolean(hasSymbols);
        return type;
    }
    
    public String gen() {
        String result = "";
        
        for (int i = 0; i < lenght; i++) {
            switch (getType()) {
                case "0000" :
                    break;
                case "0001" :
                    break;
                case "0010" :
                    break;
                case "0011" :
                    break;
                case "0100" :
                    break;
                case "0101" :
                    break;
                case "0110" :
                    break;
                case "0111" :
                    break;
                case "1000" :
                    break;
                case "1001" :
                    break;
                case "1010" :
                    break;
                case "1011" :
                    break;
                case "1100" :
                    break;
                case "1101" :
                    break;
                case "1110" :
                    break;
                case "1111" :
                    break;
            }
        }
        return result;
    }
    
    private String getSmall() {
        return Base.ENGALPHAVET[Base.randomNumber(0, Base.ENGALPHAVET.length)];
    }
    
    private String getBig() {
        return Base.ENGALPHAVETCAPS[Base.randomNumber(0, Base.ENGALPHAVETCAPS.length)];
    }
    
   private String getNumber() {
       return Base.intToString(Base.randomNumber(0, 10));
   }
    
}
