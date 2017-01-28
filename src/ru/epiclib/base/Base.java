/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.base;

import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.io.*;
import java.text.NumberFormat;

/**
 * Base functions
 *
 * @author Dmitry Tsvetkovsky
 */
public final class Base {

    public static String[] suffixes = {"K", "m", "M", "b", "B", "t", "T", "kd", "Kd", "kn", "Kn", "sx", "Sx", "sp",
        "Sp", "o", "O", "n", "N", "d", "D", "y", "Y", "dd", "Dd", "td", "Td", "kt", "Kt", "qd", "Qd", "sd", "Sd",
        "spd", "Spd", "od", "Od", "nv", "Nv", "v", "V", "av", "Av", "dv", "Dv", "tv", "Tv", "ktv", "Ktv", "qv",
        "Qv", "sxv", "Sxv", "spv", "Spv", "ov", "Ov", "nv", "Nv", "tr", "Tr", "atr", "Atr", "dtr", "Dtr", "MAX 1", "MAX 2", "MAX 3", "MAX 4"};

    public static final String[] ENGALPHAVET = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "g", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static final String[] ENGALPHAVETCAPS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "G", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static final String[] RUSALPHAVET = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я"};

    public static final String[] RUSALPHAVETCAPS = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ь", "Ы", "Ъ", "Э", "Ю", "Я"};

    private Base() {

    }

    // <editor-fold defaultstate="collapsed" desc="String Translate">
    /**
     * Преобразует string в byte
     *
     * @param string строка для преобразования
     * @return переменную типа byte
     * @throws NumberFormatException
     */
    public static byte stringToByte(String string) throws NumberFormatException {
        byte retInt = -1;
        retInt = Byte.parseByte(string);
        return retInt;
    }

    /**
     * Преобразует string в short
     *
     * @param string строка для преобразования
     * @return переменную типа short
     * @throws NumberFormatException
     */
    public static short stringToShort(String string) throws NumberFormatException {
        short retShort = -1;
        retShort = Short.parseShort(string);
        return retShort;
    }

    /**
     * Преобразует string в int
     *
     * @param string строка для преобразования
     * @return переменную типа int
     * @throws NumberFormatException
     */
    public static int stringToInt(String string) throws NumberFormatException {
        int retInt = -1;
        retInt = Integer.parseInt(string);
        return retInt;
    }

    /**
     * Преобразует string в long
     *
     * @param string строка для преобразования
     * @return переменную типа long
     * @throws NumberFormatException
     */
    public static long stringToLong(String string) throws NumberFormatException {
        long retInt = -1;
        retInt = Long.parseLong(string);
        return retInt;
    }

    /**
     * Преобразует string в float
     *
     * @param string строка для преобразования
     * @return переменную типа float
     * @throws NumberFormatException
     */
    public static float stringToFloat(String string) throws NumberFormatException {
        float retInt = -1;
        retInt = Float.parseFloat(string);
        return retInt;
    }

    /**
     * Преобразует string в double
     *
     * @param string строка для преобразования
     * @return переменную типа double
     * @throws NumberFormatException
     */
    public static double stringToDouble(String string) throws NumberFormatException {
        double retDouble = -1;
        retDouble = Double.parseDouble(string);
        return retDouble;
    }

    // </editor-fold> //javadoc +
    // <editor-fold defaultstate="collapsed" desc="SerDeser">
    /**
     * Serializing obj to file with name file_name
     *
     * @param file_name Name of file to serializing
     * @param obj Object to serializing
     * @throws java.io.FileNotFoundException
     * @throws java.io.NotSerializableException
     */
    public static void serData(String file_name, Object obj) throws NotSerializableException, IOException {

        FileOutputStream fileOut = null;

        fileOut = new FileOutputStream(file_name);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();

    }

    /**
     * Deserializing object from file with name file_name
     *
     * @param file_name Name of file to deserializing
     * @return Object from file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static Object deserData(String file_name) throws FileNotFoundException, IOException, ClassNotFoundException {
        Object retObject = null;

        InputStream fileIn = new FileInputStream(file_name);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        retObject = in.readObject();
        fileIn.close();

        return retObject;
    }

    // </editor-fold> //javadoc ++
    //<editor-fold defaultstate="collapsed" desc="Clipboard">
    public static void copyToClipboard(String myString) {
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }

    public static String stringFromClipboard() {
        StringSelection stringSelection = new StringSelection(null);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.getContents(stringSelection);
        return stringSelection.toString();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Chance">
    /**
     * Chance for 1.0%
     *
     * @param chance
     * @return
     */
    static boolean chanceProcent(int chance) {
        return mainChance(chance, 100);
    }

    /**
     * Chance for 0.1%
     *
     * @param chance
     * @return
     */
    static boolean chanceDecimal(int chance) { //0.1%
        return mainChance(chance, 1000);
    }

    /**
     * Chance for 0.01%
     *
     * @param chance
     * @return
     */
    static boolean chanceHundredth(int chance) { //0.01%
        return mainChance(chance, 10000);
    }

    /**
     * Chance for 0.001%
     *
     * @param chance
     * @return
     */
    static boolean chanceThousandth(int chance) {
        return mainChance(chance, 100000);
    }

    /**
     * Chance for 0.0001%
     *
     * @param chance
     * @return
     */
    static boolean chanceTenthousandth(int chance) {
        return mainChance(chance, 1000000);
    }

    static boolean chanceHundredthousandth(int chance) {
        return mainChance(chance, 10000000);
    }

    static boolean chanceMillonth(int chance) {
        return mainChance(chance, 100000000);
    }

    static boolean chanceMax(int chance) {
        return mainChance(chance, 1000000000);
    }

    /**
     * Gen random boolean with chance "chance"
     *
     * @param chance Chance of gen true
     * @param numberOfDigitsAfterPoint Accurate
     * @return Return boolean
     */
    public static boolean chance(int chance, int numberOfDigitsAfterPoint) {
        switch (numberOfDigitsAfterPoint) {
            case 0:
                return chanceProcent(chance);
            case 1:
                return chanceDecimal(chance);
            case 2:
                return chanceHundredth(chance);
            case 3:
                return chanceThousandth(chance);
            case 4:
                return chanceTenthousandth(chance);
            case 5:
                return chanceHundredthousandth(chance);
            case 6:
                return chanceMillonth(chance);
            case 7:
                return chanceMax(chance);
            default:
                return false;
        }
    }

    private static boolean mainChance(int chance, int max) {
        int alpha = randomNumber(1, max); // 1-max vkl
        boolean retBool = false;

        if (chance > 0) {
            if (chance < max) {
                int[] random = new int[max];
                for (int i = 0; i < random.length; i++) {
                    random[i] = 0;
                }
                for (int i = 0; i < chance; i++) {
                    random[i] = 1 + i;
                }
                for (int i = 0; i < random.length; i++) {
                    if (alpha == random[i]) {
                        retBool = true;
                    }
                }
            } else {
                retBool = true;
            }
        } else {
            retBool = false;
        }

        return retBool;
    }

    //</editor-fold>
    /**
     * Генерирует случайное число типа int, от min до max
     *
     * <p>
     * <b>min 0 max 4 => 0;1;2;3;4 min 5 max 10 => 5,6,7,8,9,10</b></p>
     *
     * @param min минимальное число
     * @param max максимальное число
     * @return Случачайное число
     * @since 1.00
     */
    public static int randomNumber(int min, int max) {
        return (int) (min + Math.random() * ((max + 1) - min));
    }

    /**
     * Генерирует случайное число типа long, от min до max
     *
     * <p>
     * <b>min 0 max 4 => 0;1;2;3;4 min 5 max 10 => 5,6,7,8,9,10</b></p>
     *
     * @param min минимальное число
     * @param max максимальное число
     * @return Случачайное число
     * @since 1.00
     */
    public static long randomNumber(long min, long max) {
        return (long) (min + Math.random() * ((max + 1) - min));
    }

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

    public static double procentOtChisla(double fullChislo, double chislo) {
        if (fullChislo == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        return chislo * 100 / fullChislo;

    }

    public static String procentOtChislaString(double fullChislo, double chislo) {

        if (fullChislo == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        double a = chislo * 100 / fullChislo;

        a = a / 100;

        NumberFormat formatter = NumberFormat.getPercentInstance();
        formatter.setMaximumFractionDigits(2);
        String s = formatter.format(a);

        return s;

    }

    public static String normal(double number, boolean kkkm) {

        String s = "";

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(0);
        s = formatter.format(number);

        if (!kkkm) {

            return s;

        } else {

            while (s.contains(" ")) {
                s = s.replaceFirst(" ", "");
            }

            int length = s.length();
            short inches = 0;

            while (length >= 6) {
                length -= 3;
                inches++;
                double tmp = number / 1000;
                number = tmp;
            }
            String suffix = "";
            if (inches != 0) {
                for (int i = 0; i < inches; i++) {
                    suffix = suffixes[i];
                }
            }

            number = Math.floor(number);
            String numberStr = normal(number, false);

            return (numberStr + suffix);
        }

    }

    public static String maximumFractionDigits(int fractionDigits, double number) {
        if (fractionDigits >= 0) {
            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(fractionDigits);
            String s = formatter.format(number);

            return s;
        } else {
            return "error";
        }
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

    /**
     * Returns randomly generated String with params
     *
     * @param length Length of String
     * @param smallLet Includes small letters?
     * @param bigLet Includes big letters?
     * @param nums Includes numbers?
     * @return Generated String
     */
    public static String randomString(int length, boolean smallLet, boolean bigLet, boolean nums) {
        if (length >= 1 && (smallLet || bigLet || nums)) {
            String retStr = "";

            for (int i = 0; i < length; i++) {

                if (nums && smallLet && bigLet) {
                    if (chanceProcent(50)) {
                        if (chanceProcent(50)) {
                            String a = ENGALPHAVET[randomNumber(1, ENGALPHAVET.length - 1)];
                            retStr += a;
                        } else {
                            String a = ENGALPHAVETCAPS[randomNumber(1, ENGALPHAVETCAPS.length - 1)];
                            retStr += a;
                        }
                    } else {
                        String a = randomNumber(0, 9) + "";
                        retStr += a;
                    }
                } else if (nums && smallLet) {
                    if (chanceProcent(50)) {
                        String a = ENGALPHAVET[randomNumber(1, ENGALPHAVET.length - 1)];
                        retStr += a;
                    } else {
                        String a = randomNumber(0, 9) + "";
                        retStr += a;
                    }
                } else if (nums && bigLet) {
                    if (chanceProcent(50)) {
                        String a = ENGALPHAVETCAPS[randomNumber(1, ENGALPHAVETCAPS.length - 1)];
                        retStr += a;
                    } else {
                        String a = randomNumber(0, 9) + "";
                        retStr += a;
                    }
                } else if (smallLet && bigLet) {
                    if (chanceProcent(50)) {
                        String a = ENGALPHAVET[randomNumber(1, ENGALPHAVET.length - 1)];
                        retStr += a;
                    } else {
                        String a = ENGALPHAVETCAPS[randomNumber(1, ENGALPHAVETCAPS.length - 1)];
                        retStr += a;
                    }
                } else if (nums) {
                    String a = randomNumber(0, 9) + "";
                    retStr += a;
                } else if (smallLet) {
                    String a = ENGALPHAVET[randomNumber(1, ENGALPHAVET.length - 1)];
                    retStr += a;
                } else if (bigLet) {
                    String a = ENGALPHAVETCAPS[randomNumber(1, ENGALPHAVETCAPS.length - 1)];
                    retStr += a;
                }

            }

            return retStr;
        } else {
            return "";
        }
    }

    public static String randomBinary(int length) {

        if (length >= 1) {
            String binary = "";

            for (int i = 0; i < length; i++) {
                binary += randomNumber(0, 1);
            }

            return binary;
        } else {
            return "";
        }

    }

    /**
     * Get one of ten indexes in the array uses chances
     *
     * @param tenChances array of chances of indexes
     * @return index
     */
    public static int chances(int[] tenChances) {
        if (tenChances.length == 10) {

            int index = -1;

            while (index == -1) {
                for (int i = 0; i < tenChances.length; i++) {
                    int tenChance = tenChances[i];
                    if (chanceProcent(tenChance)) {
                        index = i;
                        break;
                    }
                }
            }

            return index;
        } else {
            return 0;
        }
    }

    /**
     * Get one of ten indexes in the array uses chances
     *
     * @param tenChances array of chances of indexes
     * @param numberOfDigitsAfterPoint for finest acuracy
     * @return index
     */
    public static int chances(int[] tenChances, int numberOfDigitsAfterPoint) {
        if (tenChances.length == 10) {

            int index = -1;

            while (index == -1) {
                for (int i = 0; i < tenChances.length; i++) {
                    int tenChance = tenChances[i];
                    if (chance(tenChance, numberOfDigitsAfterPoint)) {
                        index = i;
                        break;
                    }
                }
            }

            return index;
        } else {
            return 0;
        }
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

    public static int getBinaryOfBoolean(boolean bool) {
        if (bool) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Generate random number from 0 to max
     *
     * @param max maximum index
     * @return Return random number from 0 to max
     */
    public static int getIndexFromList(int max) {

        Double chanceOfAnyIndexDb = new Double(100 / max);
        Double temp = chanceOfAnyIndexDb * 10000000;
        int chanceOfAnyIndex = chanceOfAnyIndexDb.intValue();
        int retIndex = -1;

        int tempIndex = 0;
        while (retIndex == -1) {
            if (chance(chanceOfAnyIndex, 7)) {
                retIndex = tempIndex;
            } else {
                tempIndex++;
            }
        }

        return retIndex;
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

}
