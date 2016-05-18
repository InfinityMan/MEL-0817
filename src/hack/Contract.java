/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ru.epiclib.base.Base;
import static ru.epiclib.base.Base.deserData;
import ru.epiclib.base.FileWorker;

/**
 *
 * @author 1234
 */
public class Contract implements Serializable {

    public Computer target;

    public String missionFull;
    public String missionShort;
    
    public int id;
    public int needLvl;
    public int type;
    
    /*
    type:
    0 - destroy
    1 - copy
    2 - virus
    */
    
    public Contract(int type, User user) {
        
        this.type = type;
        
        String all = "";
        try {
            all = FileWorker.read("Missions.txt");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Not loaded missions","Error",JOptionPane.ERROR_MESSAGE);
            
        }
        String[] mission = all.split("\n")[type].split(";");
        
        missionFull = mission[0];
        missionShort = mission[Base.randomNumber(1, mission.length)];
        
        id = user.gettedContractsNumber;
        
        int typeOfTarget = 0;
        if(User.levelNum(user.exp) >= Computer.LVLTOCOMP[1]) typeOfTarget = 1;
        if(User.levelNum(user.exp) >= Computer.LVLTOCOMP[2]) typeOfTarget = 2;
        if(User.levelNum(user.exp) >= Computer.LVLTOCOMP[3]) typeOfTarget = 3;
        if(User.levelNum(user.exp) >= Computer.LVLTOCOMP[4]) typeOfTarget = 4;
        if(User.levelNum(user.exp) >= Computer.LVLTOCOMP[5]) typeOfTarget = 5;
        
        ArrayList<Computer> computers = new ArrayList<>();
        
        try {
            computers = (ArrayList<Computer>) deserData("CompsDataBase.comps");   
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Not loaded computers","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        ArrayList<Computer> lvlComps = new ArrayList<>();
        
        for (int i = 0; i < computers.size(); i++) {
            Computer get = computers.get(i);
            if(get.getType() == typeOfTarget) {
                lvlComps.add(get);
            }
        }
        
        target = lvlComps.get(Base.randomNumber(0, lvlComps.size()));
        
        
    }
    
}
