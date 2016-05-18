/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack;

import hack.Hacknet;
import java.io.Serializable;

/**
 *
 * @author 1234
 */
public abstract class Protect implements Serializable {
    
    public int needPower;
    public int id = 0;
    
    public boolean gateway;
    
    /**
     *
     */
    public Hacknet hacknet;
    
    public boolean open = false;
    
    abstract public void hackThis();
    abstract public String printThis();
    
}
