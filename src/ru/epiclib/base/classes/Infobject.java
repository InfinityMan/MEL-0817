/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.epiclib.base.classes;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Dima
 */
public class Infobject implements Serializable {
    
    public SString a;
    public SString b;
    
    public Infobject() {
        
    }
    
    public Infobject(SString a) {
        this.a = a;
        b = new SString("No info");
    }
    
    public Infobject(String a) {
        this.a = new SString(a);
        b = new SString("No info");
    }
    
    public Infobject(SString a, SString b) {
        this.a = a;
        this.b = b;
    }
    
    public Infobject(String a, String b) {
        this.a = new SString(a);
        this.b = new SString(b);
    }

    public SString getA() {
        return a;
    }
    public void setA(SString a) {
        this.a = a;
    }

    public SString getB() {
        return b;
    }
    public void setB(SString b) {
        this.b = b;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.a);
        hash = 97 * hash + Objects.hashCode(this.b);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Infobject other = (Infobject) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Infobject{" + "a = \"" + a + "\", b = \"" + b + "\"}'";
    }

    
    
}
