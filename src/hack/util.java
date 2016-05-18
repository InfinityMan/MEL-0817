/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack;

import java.io.IOException;
import java.util.ArrayList;
import ru.epiclib.base.Base;

/**
 *
 * @author Dima
 */
public class util {
    public static void main(String[] args) {
        ArrayList<Computer> cmrs = new ArrayList<>();
        cmrs.add(new Computer(4, "Crystal", "Crys"));
        cmrs.add(new Computer(1, "Red", "Red"));
        cmrs.add(new Computer(5, "Mios", "Mi"));
        cmrs.add(new Computer(2, "Hato", "Hato"));
        cmrs.add(new Computer(0, "Andre", "An"));
        cmrs.add(new Computer(3, "Bino", "Bin"));
        cmrs.add(new Computer(1, "Fero", "Fer"));
        cmrs.add(new Computer(2, "Kir", "Kir"));
        Base.serData("CompsDataBase.comps", cmrs);
    }
}
