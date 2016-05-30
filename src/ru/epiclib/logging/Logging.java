/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.logging;

import java.util.Calendar;
import java.util.logging.LogRecord;

/**
 *
 * @author Dima
 */
public class Logging {
    public static String getMessageFromRecord(LogRecord record) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(record.getMillis());
        String timeStr = time.getTime() + "";
        String classAndMethod = record.getSourceClassName() + "." + record.getSourceMethodName()+"()";
        String message = record.getLevel().getLocalizedName() + " : " + record.getMessage();
        return "[" + timeStr + "][" + classAndMethod + "]" + message;
    }
}
