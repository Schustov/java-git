package game;

public class Warrior {
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