package game;

import java.util.*;

//Король
class King {
    public int healthPoints;
    public int gold;
    public King(int healthPoints, int gold) {
        this.healthPoints = healthPoints;
        this.gold = gold;
    }
    public void takeGold(int gold) {
        if (this.gold > 0) {
            this.gold -= gold;
        }
        if (this.gold < 0) {
            this.gold = 0;
        }
    }

    public int getGold() {
        return gold;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
}

// Базовый класс для воинов
class Warrior {
    public String type;
    public int healthPoints;
    public int attackDamage;
    public Warrior(int healthPoints, int attackDamage, String type) {
        this.healthPoints = healthPoints;
        this.attackDamage = attackDamage;
        this.type = type;
    }

    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints <= 0) {
            this.healthPoints = 0;
            this.die();
        }
    }

    public void die() {
        System.out.println(type + " was killed.");
    }
    public void attack(Enemy enemy) {
        enemy.takeDamage(attackDamage);
        System.out.println(type + " attacked Enemy " + enemy.enemyType + ". " +
                "Enemy " + enemy.enemyType + " health: " + enemy.healthPoints);

    }

    public int getHealthPoints() {
        return healthPoints;
    }
}

//Рыцарь
class Knight extends Warrior {
    public Knight () {
        super(500, 10, "Knight");
    }
}

//Пехотинец
class Soldier extends Warrior{
    public Soldier() {
        super(300, 5, "Soldier");
    }
}

// Класс для врагов
class Enemy{
    public int enemyType;
    public int gold;
    public int healthPoints;
    public int attackDamage;
    public Enemy(int enemyType) {
        this.enemyType = enemyType;
        if (enemyType == 1) {
            this.healthPoints = 100;
            this.attackDamage = 5;
        } else if (enemyType == 2) {
            this.healthPoints = 100;
            this.attackDamage = 10;
            this.gold = 50;
        } else if (enemyType == 3) {
            this.healthPoints = 100;
            this.attackDamage = 50;
            this.gold = 100;
        }
    }

    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints <= 0) {
            this.healthPoints = 0;
            this.die();
        }
    }
    public int getHealthPoints() {
        return healthPoints;
    }

    public void attack(Warrior warrior, King king) {
        if ((enemyType == 2 || enemyType == 3) && warrior.healthPoints > 0) {
            king.takeGold(gold);
        }
        warrior.takeDamage(attackDamage);
        System.out.println("Enemy " + enemyType + " attacked " + warrior.type + ". " + warrior.type + " health: " +
                warrior.healthPoints + ". The king has " + king.getGold() + " gold left");

    }
    public void die() {
        System.out.println("Enemy " + enemyType + " was killed.");
    }

}

public class Game {
    public static void main(String[] args) {
        boolean status = true;

        King king = new King(100, 10000);

        List<Warrior> army = new ArrayList<Warrior>();
        army.add(new Knight());
        army.add(new Soldier());
        List<Warrior> army_1 = new ArrayList<Warrior>(army);

        List<Enemy> enemy = new ArrayList<Enemy>();
        enemy.add(new Enemy(1));
        enemy.add(new Enemy(2));
        enemy.add(new Enemy(3));
        List<Enemy> enemy_1 = new ArrayList<Enemy>(enemy);

        Random r = new Random();
        while (true) {
            try {
                army.get(r.nextInt(army.size())).attack(enemy.get(r.nextInt(enemy.size())));
            } catch (IllegalArgumentException e) {
                System.out.println("The enemies stole all the King's gold: " + king.getGold());
                return;
            }

            for (Enemy e : enemy) {
                if (e.getHealthPoints() == 0) {
                    enemy_1.remove(e);
                }
            }
            enemy = new ArrayList<Enemy>(enemy_1);

            try {
                enemy.get(r.nextInt(enemy.size())).attack(army.get(r.nextInt(army.size())), king);
            } catch (IllegalArgumentException e) {
                System.out.println("The King has won");
                return;
            }

            for (Warrior w : army) {
                if (w.getHealthPoints() == 0) {
                    army_1.remove(w);

                }
            }
            army = new ArrayList<Warrior>(army_1);
        }
    }
}

