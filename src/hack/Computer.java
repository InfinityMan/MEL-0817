/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack;

import static hack.User.levelText;
import hack.protect.*;
import java.io.FileNotFoundException;
import java.io.Serializable;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.logging.Logger;
import ru.epiclib.base.Base;
import static java.lang.Thread.sleep;
import static ru.epiclib.base.FileWorker.read;


public class Computer implements Serializable {
    
    private static final long serialVersionUID = 2L;
    
    public static final int[] EXPS = {8,14,22,48,80,190};
    public static final int[] LVLTOCOMP = {1,8,17,24,32,43};
    public static final String[] TYPES = {"Old server","Local server","Small server","Normal server","Big server","Super server"};
    public static final String[] SUFNAME = {"workstation","station","base","frame","mainframe","grandframe"};
    
    public ArrayList<Protect> defenseList;
    
    public int trace,exp;
    
    public String ip, nameComputer;
    
    public ArrayList<GFile> files;
    
    public String prefix;
    
    public boolean hacked = false, virused = false;
    
    public AuthWindow aw;
    
    public String nameOfFileDeleted;
    
    public String print() {
        return TYPES[getType()] + ", name: \""+nameComputer+"\", ip: "+ip+", hacked: "+hacked;
    }
    
    public int getType() {
        switch(exp) {
            case 8:
                return 0;
            case 14:
                return 1;
            case 22:
                return 2;
            case 48:
                return 3;
            case 80:
                return 4;
            case 190:
                return 5;
            default:
                return 0;
        }
    }

    public Computer(ArrayList<Protect> defenseList, int trace, int power, String ip, String nameComputer, ArrayList<GFile> files, String prefix) {
        this.defenseList = defenseList;
        this.trace = trace;
        this.exp = power;
        this.ip = ip;
        this.nameComputer = nameComputer;
        this.files = files;
        this.prefix = prefix;
    }
    
    public Computer(int type, String nameComputer, String prefix) {
        exp = EXPS[type];
        ArrayList<Protect> df = new ArrayList<>();
        df.add(new SPro());
        if(type > 0) df.add(new Proxy());
        if(type > 1) {
            df.add(new Firewall());
            df.add(new AntiHack());
        }
        if(type > 2) {
            df.add(new Alpha());
            df.add(new Prote());
        }
        if(type > 3) df.add(new Ello());
        if(type > 4) df.add(new Zeus());
        
        defenseList = df;
        
        switch(type) {
            case 0:
                trace = 0;
                break;
            case 1:
                trace = 240;
                break;
            case 2:
                trace = 120;
                break;
            case 3:
                trace = 60;
                break;
            case 4:
                trace = 30;
                break;
            case 5:
                trace = 10;
                break;
        }
        
        this.ip = ip;
        this.nameComputer = nameComputer + " " + SUFNAME[type];
        this.prefix = prefix;
        
        ArrayList<GFile> gf = new ArrayList<>();
        
        for (int i = 0; i < Base.randomNumber(7, 17); i++) {
            gf.add(new GFile(prefix+"-"+Base.randomNumber(101, 99999999), "dat"));
        }
        
        files = gf;
        
        ip = genIP();
        
    }
    
    public Computer(int type, String nameComputer, String prefix, String ip) {
        exp = EXPS[type];
        ArrayList<Protect> df = new ArrayList<>();
        df.add(new SPro());
        if(type > 0) df.add(new Proxy());
        if(type > 1) {
            df.add(new Firewall());
            df.add(new AntiHack());
        }
        if(type > 2) {
            df.add(new Alpha());
            df.add(new Prote());
        }
        if(type > 3) df.add(new Ello());
        if(type > 4) df.add(new Zeus());
        
        defenseList = df;
        
        switch(type) {
            case 0:
                trace = 0;
                break;
            case 1:
                trace = 240;
                break;
            case 2:
                trace = 120;
                break;
            case 3:
                trace = 60;
                break;
            case 4:
                trace = 30;
                break;
            case 5:
                trace = 10;
                break;
        }
        
        this.ip = ip;
        this.nameComputer = nameComputer + " " + SUFNAME[type];
        this.prefix = prefix;
        
        ArrayList<GFile> gf = new ArrayList<>();
        
        for (int i = 0; i < Base.randomNumber(7, 17); i++) {
            gf.add(new GFile(prefix+"-"+Base.randomNumber(101, 99999999), "dat"));
        }
        
        files = gf;
        
    }
    
    /*public Computer(int level) {
    
    int code = 0;
    
    int[] a = {1,2,4,5,6,10,25,35,0,0};
    int[] b = {3,4,6,9,12,27,40,0,0,0};
    int[] c = {4,6,10,15,28,40,0,0,0,0};
    int[] d = {6,8,14,20,38,0,0,0,0,0};
    int[] e = {9,12,25,40,0,0,0,0,0,0};
    int[] f = {15,27,40,0,0,0,0,0,0,0};
    int[] g = {30,60,0,0,0,0,0,0,0,0};
    
    if(level >= 54) {
    code = Base.chances(a);
    } else if(level >= 48) {
    code = Base.chances(b);
    } else if(level >= 42) {
    code = Base.chances(c);
    } else if(level >= 31) {
    code = Base.chances(d);
    } else if(level >= 25) {
    code = Base.chances(e);
    } else if(level >= 18) {
    code = Base.chances(f);
    } else if(level >= 8) {
    code = Base.chances(g);
    } else code = 0;
    
    boolean pro1 = Base.chance(75);
    boolean pro2 = Base.chance(75);
    
    defenseList = new ArrayList<>();
    defenseList.add(new SPro());
    
    
    switch(code) {
    case 0:
    power = 8;
    trace = 0;
    break;
    case 1:
    power = 14;
    trace = 0;
    if(pro1) defenseList.add(new FTPPort());
    break;
    case 2:
    power = 26;
    trace = 0;
    
    defenseList.add(new FTPPort());
    
    if(pro1) defenseList.add(new HTTPPort());
    if(pro2) defenseList.add(new PassiveAntivirus());
    break;
    case 3:
    power = 36;
    trace = 180;
    
    defenseList.add(new FTPPort());
    defenseList.add(new HTTPPort());
    defenseList.add(new PassiveAntivirus());
    
    if(pro1) defenseList.add(new SQLPort());
    if(pro2) defenseList.add(new ActiveAntivirus());
    break;
    case 4:
    power = 100;
    trace = 120;
    
    defenseList.add(new FTPPort());
    defenseList.add(new HTTPPort());
    defenseList.add(new PassiveAntivirus());
    defenseList.add(new SQLPort());
    defenseList.add(new ActiveAntivirus());
    
    if(pro1) defenseList.add(new Proxy());
    if(pro2) defenseList.add(new Beta());
    break;
    case 5:
    power = 180;
    trace = 90;
    
    defenseList.add(new FTPPort());
    defenseList.add(new HTTPPort());
    defenseList.add(new PassiveAntivirus());
    defenseList.add(new SQLPort());
    defenseList.add(new ActiveAntivirus());
    defenseList.add(new Proxy());
    defenseList.add(new Beta());
    
    if(pro1) defenseList.add(new Prote());
    break;
    case 6:
    power = 250;
    trace = 60;
    
    defenseList.add(new FTPPort());
    defenseList.add(new HTTPPort());
    defenseList.add(new PassiveAntivirus());
    defenseList.add(new SQLPort());
    defenseList.add(new ActiveAntivirus());
    defenseList.add(new Proxy());
    defenseList.add(new Beta());
    defenseList.add(new Prote());
    
    if(pro1) defenseList.add(new Firewall());
    if(pro2) defenseList.add(new Alpha());
    break;
    case 7:
    power = 500;
    trace = 30;
    
    defenseList.add(new FTPPort());
    defenseList.add(new HTTPPort());
    defenseList.add(new PassiveAntivirus());
    defenseList.add(new SQLPort());
    defenseList.add(new ActiveAntivirus());
    defenseList.add(new Proxy());
    defenseList.add(new Beta());
    defenseList.add(new Prote());
    defenseList.add(new Firewall());
    defenseList.add(new Alpha());
    
    if(pro1) defenseList.add(new Zeus());
    break;
    }
    
    ip = genIP();
    
    nameComputer = ip + " base";
    
    }*/
    

    public static String genIP() {
        return Base.randomCombineString(5);
    }
    

    public void loadHacknetToProtect(Hacknet hacknet) {
        for (int i = 0; i < defenseList.size(); i++) {
            Protect get = defenseList.get(i);
            get.hacknet = hacknet;
        }
    }
    
    public boolean hasFile(GFile file) {
        boolean ret = false;
        for (int i = 0; i < files.size(); i++) {
            GFile get = files.get(i);
            if(get.equals(file)) {
                ret = true;
            }
        }
        return ret;
    }
    
    public void rm(GFile file) {
        for (int i = 0; i < files.size(); i++) {
            GFile get = files.get(i);
            if(get.equals(file)) {
                nameOfFileDeleted = file.toString();
                files.remove(i);
            }
        }
    }
    
    public String printScan() {
        String first = "Result of scan: \n"
                + " Admin: "+hacked+"\n"
                + " Name of computer: "+nameComputer+"\n"
                + " IP adress: "+ip+"\n"
                + " Protect systems: \n";
        String second = "";
        for (int i = 0; i < defenseList.size(); i++) {
            Protect get = defenseList.get(i);
            second += "     " + get.printThis() + "\n";
        }
        String third = " Trace: "+trace+"\n"
                + " Power: "+exp;
        
        return first + second + third;
        
    }

    public void hack(final User user) {

        Thread myThready = new Thread(() -> {
            MiniHacknet mh;
            mh = new MiniHacknet();
            mh.setVisible(true);
            
            for (int i = exp * 2; i > 0; i--) {
                try {
                    mh.print(read("words.txt").split(" ")[i]);
                } catch (FileNotFoundException ex) {
                    exit(1);
                }
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    exit(1);
                }
            }
            mh.print("Complete hack of computer");
            hacked = true;
            user.exp += exp;
            mh.print("You get " + exp + " exp, and your level now : " + levelText(user.exp));
            
            try {
                sleep(3_000);
            } catch (InterruptedException ex) {
                exit(1);
            }
            mh.dispose();
        });
        myThready.start();
        
    }
    private static final Logger LOG = Logger.getLogger(Computer.class.getName());
    
    
    
}
