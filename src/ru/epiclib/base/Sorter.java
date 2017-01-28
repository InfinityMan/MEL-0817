/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.base;

/**
 *
 * @author Dmig
 */
public final class Sorter {

    private Sorter() {

    }

    public static void main(String[] args) {
        int[] input = {2, 7, 9};
        int[][] current = new int[input.length][];
        for (int i = 0; i < input.length; i++) {
            current[i] = new int[1];
            current[i][0] = input[i];
        }
        for (int[] current1 : current) {
            for (int j = 0; j < current1.length; j++) {
                System.out.println(current1[j]);
            }
            System.out.println(15 % 2);
        }
    }

    private static boolean testForSortered(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            if (!(input[i] <= input[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static int[] sliyanie(int[] input) throws IllegalArgumentException {
        if (input.length > 1) {
            if (testForSortered(input)) {
                return input;
            }

            int[] output = null;
            int[][] current = new int[input.length][];
            for (int i = 0; i < input.length; i++) {
                current[i] = new int[1];
                current[i][0] = input[i];
            }
            boolean sortEnded = false;

            while (!sortEnded) {
                if (current.length != 1) {
                    int firstIndex = 0, secondIndex = 0, finalIndex = 0, j = 0;
                    int[][] newCurrent;
                    if (current[j][firstIndex] <= current[j + 1][secondIndex]) {

                    } else {

                    }
                } else {
                    sortEnded = true;
                }
            }

            return output;
        } else if (input.length == 1) {
            return input;
        } else {
            throw new IllegalArgumentException("Length of input array is 0");
        }
    }

}
