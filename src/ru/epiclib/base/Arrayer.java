/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.base;

/**
 * Class for working with arrays
 * @author Dmig
 */
public final class Arrayer {

    public static int findInCharArrayChar(char[] charArray, char symbol) {
        int retInt = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == symbol) {
                retInt++;
            }
        }
        return retInt;
    }

    public static int[] bubbleSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int b = array[j]; // change for elements
                    array[j] = array[j + 1];
                    array[j + 1] = b;
                }
            }
        }
        return array;
    }

    public static double[] bubbleSort(double array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double b = array[j]; // change for elements
                    array[j] = array[j + 1];
                    array[j + 1] = b;
                }
            }
        }
        return array;
    }

    public static String charArrayToString(char[] charArray) {

        String retString = "";
        for (int i = 0; i < charArray.length; i++) {
            retString += charArray[i];
        }

        return retString;

    }

    public static String intArrayToString(int[] intArray) {

        String retString = "";
        for (int i = 0; i < intArray.length; i++) {
            retString += intArray[i] + "";
        }

        return retString;

    }

    public static double[] concatArray(double[] a, double[] b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        double[] r = new double[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }

    public static String[] concatArray(String[] a, String[] b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        String[] r = new String[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }

    public static double mediumValueOfArray(int[] array) {
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            result = result + array[i];
        }

        return result / array.length;
    }

    public static double mediumValueOfArray(double[] array) {
        double result = 0;

        for (int i = 0; i < array.length; i++) {
            result = result + array[i];
        }

        return result / array.length;
    }

    public static double minDoubleInArray(double[] a) {
        double min = a[0];
        for (double x : a) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }

    public static double maxDoubleInArray(double[] a) {
        double min = a[0];
        for (double x : a) {
            if (x > min) {
                min = x;
            }
        }
        return min;
    }

    public static String[] deleteElementOfArray(String[] array, int index) {
        if (index >= 0 && index < array.length) {
            String[] copy = new String[array.length - 1];
            System.arraycopy(array, 0, copy, 0, index);
            System.arraycopy(array, index + 1, copy, index, array.length - index - 1);
            return copy;
        }
        return array;
    }

    public static void reverseArray(int[] input) {
        // handling null, empty and one element array
        if (input == null || input.length <= 1) {
            return;
        }
        for (int i = 0; i < input.length / 2; i++) {
            int temp = input[i];
            // swap numbers
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }
    }

}
