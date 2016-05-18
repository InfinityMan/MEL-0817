/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack;

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
        cmrs.add(new Computer(0, "Ivan", "Ivan"));
        cmrs.add(new Computer(4, "Mirt", "Mirt"));
        cmrs.add(new Computer(2, "Fios", "Fios"));
        cmrs.add(new Computer(1, "Alt", "Alt"));
        cmrs.add(new Computer(3, "Steos", "Ste"));
        cmrs.add(new Computer(5, "Goegle", "Gog"));
        cmrs.add(new Computer(0, "Tea", "Tea"));
        Base.serData("CompsDataBase.comps", cmrs);
    }
}
