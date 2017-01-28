/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.crypto;

import java.util.logging.Logger;

/**
 *
 * @author Dima
 */
public final class Cypher {
    
    private Cypher() {
        
    }
    
    private static int charFunc(int checkChr, boolean little) {
        int alphavet = 25;
        int[] boards = {65, 90, 97, 122};
        if (little) {
            if (checkChr > boards[3]) {
                checkChr -= alphavet;
            } else if (checkChr < boards[2]) {
                checkChr += alphavet;
            }
        } else {
            if (checkChr > boards[1]) {
                checkChr -= alphavet;
            } else if (checkChr < boards[0]) {
                checkChr += alphavet;
            }
        }
        return checkChr;
    }
 
    public static String caesarCypher(char [] codidStr, int offset) {
        int[] futureKeys = new int[codidStr.length];
        for (int i = 0; i < futureKeys.length; i++) {
            futureKeys[i] = offset;
        }
        return caesarCypher(codidStr, futureKeys);
    }
    
    public static String caesarCypher(char [] codidStr, int[] key) {
        try {
            for (int i = 0; i < codidStr.length; i++) {
                if (codidStr[i] >= 'A' && codidStr[i] <= 'Z') {
                    codidStr[i] = (char) charFunc(codidStr[i] + key[i],false);
                } else if (codidStr[i] >= 'a' && codidStr[i] <= 'z') {
                    codidStr[i] = (char) charFunc(codidStr[i] + key[i],true);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Key[] has smaller lenght than a codidStr[]");
        }
        return new String(codidStr);
    }
    
    private static final Logger LOG = Logger.getLogger(Cypher.class.getName());
    
}
