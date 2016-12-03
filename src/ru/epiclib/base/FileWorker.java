package ru.epiclib.base;

import java.io.*;

public class FileWorker {

    public static void write(String fileName, String text) {
        File file = new File(fileName);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            out.print(text);
            out.close();
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(File file, String text) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String read(String fileName) throws FileNotFoundException {

        File file = new File(fileName);

        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                } finally {
                    in.close();
                }
            } catch (FileNotFoundException e) {
                file.createNewFile();
            }
        } catch (IOException ex) {
            System.exit(1);
        }

        return sb.toString();
    }

    public static String read(File file) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                } finally {
                    in.close();
                }
            } catch (FileNotFoundException e) {
                file.createNewFile();
            }
        } catch (IOException ex) {
            System.exit(1);
        }

        return sb.toString();
    }

    public static String read(String fileName, String record) throws FileNotFoundException {

        File file = new File(fileName);

        return readCore(file, record);
    }

    public static String read(File file, String record) throws FileNotFoundException {
        return readCore(file, record);
    }

    private static String readCore(File file, String record) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        try {
            try {
                try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                }
            } catch (FileNotFoundException e) {
                file.createNewFile();
                write(file, record);
            }
        } catch (IOException ex) {
            System.exit(1);
        }

        return sb.toString();
    }

    public static void delete(String nameFile) throws FileNotFoundException {
        existsEx(nameFile);
        new File(nameFile).delete();
    }

    private static void existsEx(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }
    
    public static boolean exists(String fileName) {
        return new File(fileName).exists();
    }
    
}
