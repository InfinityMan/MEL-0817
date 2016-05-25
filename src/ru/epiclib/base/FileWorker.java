package ru.epiclib.base;

import java.io.*;

public class FileWorker {

    public static void write(String fileName, String text) {
        //РћРїСЂРµРґРµР»СЏРµРј С„Р°Р№Р»
        File file = new File(fileName);

        try {
            //РїСЂРѕРІРµСЂСЏРµРј, С‡С‚Рѕ РµСЃР»Рё С„Р°Р№Р» РЅРµ СЃСѓС‰РµСЃС‚РІСѓРµС‚ С‚Рѕ СЃРѕР·РґР°РµРј РµРіРѕ
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter РѕР±РµСЃРїРµС‡РёС‚ РІРѕР·РјРѕР¶РЅРѕСЃС‚Рё Р·Р°РїРёСЃРё РІ С„Р°Р№Р»
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Р—Р°РїРёСЃС‹РІР°РµРј С‚РµРєСЃС‚ Сѓ С„Р°Р№Р»
                out.print(text);
            } finally {
                //РџРѕСЃР»Рµ С‡РµРіРѕ РјС‹ РґРѕР»Р¶РЅС‹ Р·Р°РєСЂС‹С‚СЊ С„Р°Р№Р»
                //Р�РЅР°С‡Рµ С„Р°Р№Р» РЅРµ Р·Р°РїРёС€РµС‚СЃСЏ
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(File file, String text) {
        try {
            //РїСЂРѕРІРµСЂСЏРµРј, С‡С‚Рѕ РµСЃР»Рё С„Р°Р№Р» РЅРµ СЃСѓС‰РµСЃС‚РІСѓРµС‚ С‚Рѕ СЃРѕР·РґР°РµРј РµРіРѕ
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter РѕР±РµСЃРїРµС‡РёС‚ РІРѕР·РјРѕР¶РЅРѕСЃС‚Рё Р·Р°РїРёСЃРё РІ С„Р°Р№Р»
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Р—Р°РїРёСЃС‹РІР°РµРј С‚РµРєСЃС‚ Сѓ С„Р°Р№Р»
                out.print(text);
            } finally {
                //РџРѕСЃР»Рµ С‡РµРіРѕ РјС‹ РґРѕР»Р¶РЅС‹ Р·Р°РєСЂС‹С‚СЊ С„Р°Р№Р»
                //Р�РЅР°С‡Рµ С„Р°Р№Р» РЅРµ Р·Р°РїРёС€РµС‚СЃСЏ
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String read(String fileName) throws FileNotFoundException {

        //РћРїСЂРµРґРµР»СЏРµРј С„Р°Р№Р»
        File file = new File(fileName);

        //Р­С‚РѕС‚ СЃРїРµС†. РѕР±СЉРµРєС‚ РґР»СЏ РїРѕСЃС‚СЂРѕРµРЅРёСЏ СЃС‚СЂРѕРєРё
        StringBuilder sb = new StringBuilder();
        try {
            try {
                //РћР±СЉРµРєС‚ РґР»СЏ С‡С‚РµРЅРёСЏ С„Р°Р№Р»Р° РІ Р±СѓС„РµСЂ
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    //Р’ С†РёРєР»Рµ РїРѕСЃС‚СЂРѕС‡РЅРѕ СЃС‡РёС‚С‹РІР°РµРј С„Р°Р№Р»
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                } finally {
                    //РўР°РєР¶Рµ РЅРµ Р·Р°Р±С‹РІР°РµРј Р·Р°РєСЂС‹С‚СЊ С„Р°Р№Р»
                    in.close();
                }
            } catch (FileNotFoundException e) {
                file.createNewFile();
            }
        } catch (IOException ex) {
            System.exit(1);
        }

        //Р’РѕР·РІСЂР°С‰Р°РµРј РїРѕР»СѓС‡РµРЅРЅС‹Р№ С‚РµРєСЃС‚ СЃ С„Р°Р№Р»Р°
        return sb.toString();
    }

    public static String read(File file) throws FileNotFoundException {

        //Р­С‚РѕС‚ СЃРїРµС†. РѕР±СЉРµРєС‚ РґР»СЏ РїРѕСЃС‚СЂРѕРµРЅРёСЏ СЃС‚СЂРѕРєРё
        StringBuilder sb = new StringBuilder();
        try {
            try {
                //РћР±СЉРµРєС‚ РґР»СЏ С‡С‚РµРЅРёСЏ С„Р°Р№Р»Р° РІ Р±СѓС„РµСЂ
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    //Р’ С†РёРєР»Рµ РїРѕСЃС‚СЂРѕС‡РЅРѕ СЃС‡РёС‚С‹РІР°РµРј С„Р°Р№Р»
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                } finally {
                    //РўР°РєР¶Рµ РЅРµ Р·Р°Р±С‹РІР°РµРј Р·Р°РєСЂС‹С‚СЊ С„Р°Р№Р»
                    in.close();
                }
            } catch (FileNotFoundException e) {
                file.createNewFile();
            }
        } catch (IOException ex) {
            System.exit(1);
        }

        //Р’РѕР·РІСЂР°С‰Р°РµРј РїРѕР»СѓС‡РµРЅРЅС‹Р№ С‚РµРєСЃС‚ СЃ С„Р°Р№Р»Р°
        return sb.toString();
    }

    public static String read(String fileName, String record) throws FileNotFoundException {

        //РћРїСЂРµРґРµР»СЏРµРј С„Р°Р№Р»
        File file = new File(fileName);

        //Р­С‚РѕС‚ СЃРїРµС†. РѕР±СЉРµРєС‚ РґР»СЏ РїРѕСЃС‚СЂРѕРµРЅРёСЏ СЃС‚СЂРѕРєРё
        StringBuilder sb = new StringBuilder();
        try {
            try {
                //РћР±СЉРµРєС‚ РґР»СЏ С‡С‚РµРЅРёСЏ С„Р°Р№Р»Р° РІ Р±СѓС„РµСЂ
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    //Р’ С†РёРєР»Рµ РїРѕСЃС‚СЂРѕС‡РЅРѕ СЃС‡РёС‚С‹РІР°РµРј С„Р°Р№Р»
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                } finally {
                    //РўР°РєР¶Рµ РЅРµ Р·Р°Р±С‹РІР°РµРј Р·Р°РєСЂС‹С‚СЊ С„Р°Р№Р»
                    in.close();
                }
            } catch (FileNotFoundException e) {
                file.createNewFile();
                write(file, record);
            }
        } catch (IOException ex) {
            System.exit(1);
        }

        //Р’РѕР·РІСЂР°С‰Р°РµРј РїРѕР»СѓС‡РµРЅРЅС‹Р№ С‚РµРєСЃС‚ СЃ С„Р°Р№Р»Р°
        return sb.toString();
    }

    public static String read(File file, String record) throws FileNotFoundException {
        //Р­С‚РѕС‚ СЃРїРµС†. РѕР±СЉРµРєС‚ РґР»СЏ РїРѕСЃС‚СЂРѕРµРЅРёСЏ СЃС‚СЂРѕРєРё
        StringBuilder sb = new StringBuilder();
        try {
            try {
                //РћР±СЉРµРєС‚ РґР»СЏ С‡С‚РµРЅРёСЏ С„Р°Р№Р»Р° РІ Р±СѓС„РµСЂ
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    //Р’ С†РёРєР»Рµ РїРѕСЃС‚СЂРѕС‡РЅРѕ СЃС‡РёС‚С‹РІР°РµРј С„Р°Р№Р»
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                } finally {
                    //РўР°РєР¶Рµ РЅРµ Р·Р°Р±С‹РІР°РµРј Р·Р°РєСЂС‹С‚СЊ С„Р°Р№Р»
                    in.close();
                }
            } catch (FileNotFoundException e) {
                file.createNewFile();
                write(file, record);
            }
        } catch (IOException ex) {
            System.exit(1);
        }

        //Р’РѕР·РІСЂР°С‰Р°РµРј РїРѕР»СѓС‡РµРЅРЅС‹Р№ С‚РµРєСЃС‚ СЃ С„Р°Р№Р»Р°
        return sb.toString();
    }

    public static void delete(String nameFile) throws FileNotFoundException {
        exists(nameFile);
        new File(nameFile).delete();
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }
}
