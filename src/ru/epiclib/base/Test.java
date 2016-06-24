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
        String message = "message";
        int[] key = {2,3,7,9,0,4};
        System.out.println(message);
        System.out.println(Cypher.caesarCypher(message.toCharArray(), key));
    }
    private static final Logger LOG = Logger.getLogger(Test.class.getName());
}
