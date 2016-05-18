/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.protect;

import hack.Protect;
import java.io.Serializable;

/**
 *
 * @author Dima
 */
public class AntiHack extends Protect implements Serializable{

    @Override
    public void hackThis() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String printThis() {
        return "Antihack : "+open;
    }
    
}
