/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.logging;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import ru.epiclib.base.FileWorker;


/**
 *
 * @author Dima
 */
public final class Logging {
    
    public static final Handler stndHandler() {
        return new Handler() {
            
            PrintWriter out;
            String str;
            boolean firstWrite = true;
            {
                File file = new File("log.txt").getAbsoluteFile();
                
                
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    str = FileWorker.read(file);
                    this.out = new PrintWriter(file);
                } catch (IOException ex) {}
            }
            
            @Override
            public void publish(LogRecord record) {
                if(firstWrite) {
                    out.println(str);
                    firstWrite = !firstWrite;
                }
                out.println(Logging.getMessageFromRecord(record));
            }

            @Override
            public void flush() {
                out.flush();
            }

            @Override
            public void close() throws SecurityException {
                out.close();
            }
        };
    }
    
    public static final String getMessageFromRecord(LogRecord record) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(record.getMillis());
        String timeStr = time.getTime() + "";
        String classAndMethod = record.getSourceClassName() + "." + record.getSourceMethodName()+"()";
        String message = record.getLevel().getLocalizedName() + " : " + record.getMessage();
        return "[" + timeStr + "][" + classAndMethod + "]" + message;
    }
}
