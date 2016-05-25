/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Dmitry
 */
public class Console {
    
    public static String userString() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.readLine();
    }
    
    public static byte userByte() throws IOException, NumberFormatException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return Base.stringToByte(in.readLine());
    }
    
    public static short userShort() throws IOException, NumberFormatException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return Base.stringToShort(in.readLine());
    }
    
    public static int userInt() throws IOException, NumberFormatException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return Base.stringToInt(in.readLine());
    }
    
    public static long userLong() throws IOException, NumberFormatException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return Base.stringToLong(in.readLine());
    }
    
    public static float userFloat() throws IOException, NumberFormatException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return Base.stringToFloat(in.readLine());
    }
    
    public static double userDouble() throws IOException, NumberFormatException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return Base.stringToDouble(in.readLine());
    }
    
}
