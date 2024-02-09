package game;

public class Enemy{
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
