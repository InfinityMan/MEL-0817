/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.base.classes;

import java.io.Serializable;
import java.util.Objects;
import ru.epiclib.base.Base;

/**
 *
 * @author Dmitry Tsvetkovsky
 */
public class SString implements Serializable {

    private String string;

    public SString(String string) {
        this.string = string;
    }

    public SString() {

    }

    public SString(char[] charArray) {
        string = String.valueOf(charArray);
    }
    
    public SString(char charV) {
        string = String.valueOf(charV);
    }

    /**
     * @param string the string to set
     */
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.string);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SString other = (SString) obj;
        if (!Objects.equals(this.string, other.string)) {
            return false;
        }
        return true;
    }
    
    public boolean equalsIC(SString another) {
        return (string.equalsIgnoreCase(another.toString()));
    }

    public void cipher(String key) throws IllegalArgumentException {

        String thisString = string;
        byte[] keyArray = new byte[key.length()];
        
        

        thisString = thisString.toLowerCase();

        for (int i = 0; i < key.length(); i++) {
            keyArray[i] = Byte.parseByte(key.substring(i, i + 1));
        }

        int d = 0;

        for (int i = 0; i < thisString.length(); i++) {
            int tmp = -1;
            boolean eng = true;
            boolean big = false;

            if (keyArray.length == d) {
                d = 0;
            } else {
                d++;
            }

            for (int j = 0; j < Base.ENGALPHAVET.length; j++) {
                if (tmp == -1) {
                    if (thisString.charAt(i) == Base.ENGALPHAVET[j].charAt(0)) {
                        tmp = j;
                    } else if (thisString.charAt(i) == ' ') {
                        tmp = -2;
                    } else if(thisString.charAt(i) == Base.ENGALPHAVETCAPS[j].charAt(0)) {
                        tmp = j;
                        big = true;
                    }
                }
            }
            if (tmp == -1) {
                for (int j = 0; j < Base.RUSALPHAVET.length; j++) {
                    if (tmp == -1) {
                        if (thisString.charAt(i) == Base.RUSALPHAVET[j].charAt(0)) {
                            tmp = j;
                            eng = false;
                        } else if (thisString.charAt(i) == ' ') {
                            tmp = -2;
                        } else if(thisString.charAt(i) == Base.RUSALPHAVETCAPS[j].charAt(0)) {
                            tmp = j;
                            big = true;
                        }
                        
                    }
                }
            }

            if (tmp == -1) {
                throw new IllegalArgumentException();
            }

            String before = "";
            String charStr;

            if (tmp != -2) {
                if (eng) {
                    if (d - 1 >= 0) {
                        before = thisString.substring(0, d - 1);
                        if(tmp + keyArray[d - 1] < 26) {
                            charStr = Base.ENGALPHAVET[tmp + keyArray[d - 1]];
                        } else {
                            charStr = Base.ENGALPHAVET[tmp + keyArray[d - 1] - 26];
                        }
                    } else {
                        before = thisString.substring(0, 0);
                        charStr = Base.ENGALPHAVET[tmp + keyArray[0]];
                    }
                } else if (d - 1 >= 0) {
                    
                    before = thisString.substring(0, d - 1);
                    if(tmp + keyArray[d - 1] < 33) {
                    charStr = Base.RUSALPHAVET[tmp + keyArray[d - 1]];
                    } else {
                        charStr = Base.RUSALPHAVET[tmp + keyArray[d - 1] - 33];
                    }
                } else {
                    before = thisString.substring(0, 0);
                    charStr = Base.RUSALPHAVET[tmp + keyArray[0]];
                }
            } else {
                if (d - 1 >= 0) {
                    before = thisString.substring(0, d - 1);
                } else {
                    before = thisString.substring(0, 0);
                }
                charStr = " ";
            }

            String after = thisString.substring(d);

            thisString = before + charStr + after;

        }

        string = thisString;
    }

    public void deCipher(String key) throws IllegalArgumentException {

        String thisString = string;
        byte[] keyArray = new byte[key.length()];

        thisString = thisString.toLowerCase();

        for (int i = 0; i < key.length(); i++) {
            keyArray[i] = Byte.parseByte(key.substring(i, i + 1));
        }

        int d = 0;

        for (int i = 0; i < thisString.length(); i++) {
            int numberOfSymbolInArray = -1;
            boolean eng = true;

            if (keyArray.length == d) {
                d = 0;
            } else {
                d++;
            }

            for (int j = 0; j < Base.ENGALPHAVET.length; j++) {
                if (numberOfSymbolInArray == -1) {
                    if (thisString.charAt(i) == Base.ENGALPHAVET[j].charAt(0)) {
                        numberOfSymbolInArray = j;
                    } else if (thisString.charAt(i) == ' ') {
                        numberOfSymbolInArray = -2;
                    }
                }
            }
            if (numberOfSymbolInArray == -1) {
                for (int j = 0; j < Base.RUSALPHAVET.length; j++) {
                    if (numberOfSymbolInArray == -1) {
                        if (thisString.charAt(i) == Base.RUSALPHAVET[j].charAt(0)) {
                            numberOfSymbolInArray = j;
                            eng = false;
                        } else if (thisString.charAt(i) == ' ') {
                            numberOfSymbolInArray = -2;
                        }
                    }
                }
            }

            if (numberOfSymbolInArray == -1) {
                throw new IllegalArgumentException();
            }

            // TODO TODO All
            
            String before = "";
            String charStr = "";
            try {
            if (numberOfSymbolInArray != -2) {
                if (eng) {
                    if (d - 1 >= 0) {
                        before = thisString.substring(0, d - 1);
                        if(numberOfSymbolInArray - keyArray[d - 1] >= 0) {
                            charStr = Base.ENGALPHAVET[numberOfSymbolInArray - keyArray[d - 1]];
                        } else {
                            charStr = Base.ENGALPHAVET[numberOfSymbolInArray - keyArray[d - 1] + 26];
                        }
                    } else {
                        before = thisString.substring(0, 0);
                        charStr = Base.ENGALPHAVET[numberOfSymbolInArray - keyArray[0]];
                    }
                } else if (d - 1 >= 0) {
                    before = thisString.substring(0, d - 1);
                    if(numberOfSymbolInArray - keyArray[d - 1] >= 0) {
                    charStr = Base.RUSALPHAVET[numberOfSymbolInArray - keyArray[d - 1]];
                    } else {
                        charStr = Base.RUSALPHAVET[numberOfSymbolInArray - keyArray[d - 1] + 33];
                    }
                } else {
                    before = thisString.substring(0, 0);
                    charStr = Base.RUSALPHAVET[numberOfSymbolInArray - keyArray[0]];
                }
            } else {
                if (d - 1 >= 0) {
                    before = thisString.substring(0, d - 1);
                } else {
                    before = thisString.substring(0, 0);
                }
                charStr = " ";
            }
            
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("D = " + d + " I = " + i + " number = "+numberOfSymbolInArray + " key = " + keyArray[3]);
            };

            String after = thisString.substring(d);

//            if (numberOfSymbolInArray == -2) {
//                charStr = " ";
//            }

            thisString = before + charStr + after;

        }

        string = thisString;
    }

    public void deleteLastSymbol() {
        SString s = new SString("");
        char[] ar = string.toCharArray();
        char[] ar2 = new char[ar.length - 1];
        System.arraycopy(ar, 0, ar2, 0, ar2.length);
        string = String.valueOf(ar2);
    }

    public char charAt(int index) {
        return string.charAt(index);
    }

    public int codePointAt(int index) {
        return string.codePointAt(index);
    }

    public int codePointBefore(int index) {
        return string.codePointBefore(index);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        return string.codePointCount(beginIndex, endIndex);
    }

    public int length() {
        return string.length();
    }
    
    public boolean contains(SString a) {
        return string.contains(a.toString());
    }
    
    public SString[] split(SString regex) {
        String[] a = string.split(regex.toString());
        SString[] ret = new SString[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = new SString(a[i]);
        }
        return ret;
    }
    
    public void toUpperCase() {
        string = string.toUpperCase();
    }
    
    public void toLowerCase() {
        string = string.toLowerCase();
    }
    
    public void deleteSymbolAt(int position) throws IllegalArgumentException {
        
        if(position < string.length()) {
        String tmp = "";
        
        for (int i = 0; i < string.length(); i++) {
            if(i != position) {
                tmp += string.charAt(i);
            }
        }
        
        string = tmp;
        } else {
            throw new IllegalArgumentException("Position >= lenght of string");
        }
    }

}
