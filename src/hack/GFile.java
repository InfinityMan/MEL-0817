/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author 1234
 */
public class GFile implements Serializable {
    
    public String name,format;

    public GFile(String name, String format) {
        this.name = name;
        this.format = format;
    }
    
    public GFile(String nameOfFileWithFormat) {
        System.err.println(nameOfFileWithFormat);
        //if (nameOfFileWithFormat.contains(".")) {
            //String[] nOFWF = nameOfFileWithFormat.split(".");
            //name = nOFWF[0];
            //format = nOFWF[1];
        //} else {
            name = nameOfFileWithFormat;
        //}
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.format);
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
        final GFile other = (GFile) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.format, other.format)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + '.' + format;
    }
    
    
    
    private static final Logger LOG = Logger.getLogger(GFile.class.getName());
    
}
