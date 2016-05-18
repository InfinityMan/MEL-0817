/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack;

import java.io.Serializable;
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
    
    public String print() {
        return name + "." + format;
    }
    
    private static final Logger LOG = Logger.getLogger(GFile.class.getName());
    
}
