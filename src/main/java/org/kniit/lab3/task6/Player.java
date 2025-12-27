package org.kniit.lab3.task6;

public class Player {
    String name;
    int health = 100;
    int max_health = 100;
    boolean isAlive = true;
    int x;
    int y;
    int damage = 10;
    int defence = 5;

    public Player(String name) {
        this.name = name;
    }

    // Геттеры
    public String getName() {return name;}
    public int get_health() {return health;}

    void increaseHealth(int value) {
        if (value < this.max_health - this.health) {
            this.health += value;
        }
        else {
            this.health = this.max_health;
        }
    }

    void decreaseHealth(int value) {
        this.health = health + this.defence - value;
        if (this.health < 0) {
            this.isAlive = false;
        }
    }


    public double calculateDistance(Player other) {
        int deltaX = this.x - other.x;
        int deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    void moveTo(int new_x, int new_y) {
        this.x = new_x;
        this.y = new_y;
    }
}


// Класс МАГ
class Mage extends Player {
    private static final int CAST_RANGE = 10;
    private int spellPower = 10;

    public Mage(String name) {
        super(name);
    }

    public void castSpell(Player target) {
        if (!isAlive) {
            System.out.println(name + " мертв и не может атаковать!");
            return;
        }

        double distance = calculateDistance(target);
        if (distance > CAST_RANGE) {
            System.out.println(name + " не может атаковать " + target.getName() + 
                             " - цель слишком далеко (дистанция: " + distance + ")");
            return;
        }

        System.out.println(name + " бросает огненный шар в " + target.getName() + 
                         " с силой " + spellPower);

        target.decreaseHealth(spellPower);
    }

    @Override
    public String toString() {
        return "Маг " + super.toString() + ", Радиус атаки: " + CAST_RANGE;
    }
}


// Класс СВЯЩЕННИК
class Priest extends Player {
    private static final int HEAL_RANGE = 8;
    private int healPower = 10;

    public Priest(String name) {
        super(name);
    }

    public void heal(Player target) {
        if (!isAlive) {
            System.out.println(name + " мертв и не может лечить!");
            return;
        }

        double distance = calculateDistance(target);
        if (distance > HEAL_RANGE) {
            System.out.println(name + " не может исцелить " + target.getName() + 
                            " - цель слишком далеко (дистанция: " + distance + ")");
            return;
        }

        System.out.println(name + " исцеляет " + target.getName() + 
                         " на " + healPower + " единиц");

        target.increaseHealth(healPower);
    }

    @Override
    public String toString() {
        return "Священник " + super.toString() + ", Сила лечения: " + healPower;
    }
}


// Класс ВОИН
class Warrior extends Player {
    private static final int ATTACK_RANGE = 3;

    public Warrior(String name) {
        super(name);
    }

    public void attack(Player target) {
        if (!isAlive) {
            System.out.println(name + " мертв и не может атаковать!");
            return;
        }

        double distance = calculateDistance(target);
        if (distance > ATTACK_RANGE) {
            System.out.println(name + " не может атаковать " + target.getName() + 
                             " - цель слишком далеко (дистанция: " + distance + ")");
            return;
        }

        System.out.println(name + " атакует " + target.getName() + 
                         " с силой " + damage);

        target.decreaseHealth(damage);
    }

    @Override
    public String toString() {
        return "Воин " + super.toString() + ", Радиус атаки: " + ATTACK_RANGE;
    }
}


// Класс ТАНК
class Tank extends Warrior {
    public Tank(String name) {
        super(name);
    }

    private int additionalDefence = 10;

    @Override
    void decreaseHealth(int value) {
        health = defence + additionalDefence -  value;
        if (health < 0) {
            isAlive = false;
        }
    }
}


