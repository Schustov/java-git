package game;

public class King {
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