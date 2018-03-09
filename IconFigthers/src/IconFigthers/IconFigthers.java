/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IconFigthers;
import View.*;
import Classes.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Timer;

/**
 *
 * @author danie
 */
public class IconFigthers {
        static Welcome W;
        static Story S;
        static FirstFight FF;
            
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                // TODO code application logic here
                W = new Welcome();
                S = new Story();
                FF = new FirstFight();
                HazardBorn();
        }
        
        public static void Start () {
            S.setVisible(true);
        }
        
        public static void FirstFigth(){
            FF.setVisible(true);
        }
        
        public static int CounterAttack(int damagedone){
            int damage = 0;
            switch(damagedone){
                    case 1:
                        ThreadLocalRandom.current().nextInt(HazardBorn().getAttack()/5, HazardBorn().getAttack() - 20);
                    break;
                    case 2:
                        ThreadLocalRandom.current().nextInt(HazardBorn().getAttack()/4, HazardBorn().getAttack() - 15);
                    break;
            }
            return damage; 
        }
        public static Icon HazardBorn(){
            Icon Hazard = new Icon(40, 10, 90);
            return Hazard;
        }
}
  

