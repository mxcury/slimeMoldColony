import GUI.PetriDish;
import Sim.Slime;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        Timer timer  = new Timer();
        TimerTask task = new PetriDish();
        timer.scheduleAtFixedRate(task,0,16);
//        PetriDish petriDish = new PetriDish();
//        petriDish.run();
    }
}
