/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author 1GDAW02
 */
public class Icon {
    
    private int Attack;
    private int Defense;
    private int LifePoints;

    public Icon(int Attack, int Defense, int LifePoints) {
        this.Attack = Attack;
        this.Defense = Defense;
        this.LifePoints = LifePoints;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int Attack) {
        this.Attack = Attack;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

    public int getLifePoints() {
        return LifePoints;
    }

    public void setLifePoints(int LifePoints) {
        this.LifePoints = LifePoints;
    }

}
