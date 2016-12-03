/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.base;

import java.util.logging.Logger;
import ru.epiclib.base.classes.SString;
import ru.epiclib.gui.PincodPanel;

/**
 *
 * @author Dima
 */
class Test {
    public static void main(String[] args) {
        System.out.println("0237".hashCode());
        System.out.println("1000".hashCode());
        System.out.println("1337".hashCode());
    }
    private static final Logger LOG = Logger.getLogger(Test.class.getName());
}
