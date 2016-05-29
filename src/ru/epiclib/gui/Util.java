/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.gui;

import static javax.swing.UIManager.getCrossPlatformLookAndFeelClassName;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dima
 */
public class Util {
    public static void setStyle() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            // Set System L&F
            setLookAndFeel(getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            try {
                // Set cross-platform Java L&F (also called "Metal")
                setLookAndFeel(getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                System.err.println(ex);
            }
            
        }
    }
}
