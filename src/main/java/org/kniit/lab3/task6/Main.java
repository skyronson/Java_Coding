package org.kniit.lab3.task6;

public class Main {
    public static void main(String[] args) {
        
        Tank warrior = new Tank("Some Ork");
        Mage mage = new Mage("Some Mage");
        Priest priest = new Priest("Some Healer");

        // Установка позиций
        warrior.moveTo(0, 0);
        mage.moveTo(2, 0);    // В радиусе атаки воина
        priest.moveTo(1, 0);  // В радиусе лечения
        warrior.moveTo(3, 5);
        

        System.out.println("d");
        warrior.attack(mage);
        priest.heal(mage);
        mage.castSpell(warrior);
        
    }
}
