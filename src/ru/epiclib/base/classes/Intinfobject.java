/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.base.classes;

/**
 *
 * @author Dima
 */
public class Intinfobject extends Infobject {
    
    public int c;
    public int d;
    
    public Intinfobject() {
        
    }
    
    public Intinfobject(int c) {
        this.c = c;
        d = -101;
    }
    
    public Intinfobject(int c,int d) {
        this.c = c;
        this.d = d;
    }
    
    public Intinfobject(SString a, int c) {
        this.a = a;
        this.c = c;
        b = new SString("No info");
        d = -101;
    }
    
    public Intinfobject(SString a, int c, int d) {
        this.a = a;
        this.c = c;
        this.d = d;
        b = new SString("No info");
        
    }
    
    public Intinfobject(SString a, SString b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        d = -101;
    }
    
    public Intinfobject(SString a, SString b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }
    public void setD(int d) {
        this.d = d;
    }

    
    
    
    
}
