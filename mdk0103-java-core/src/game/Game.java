package game;

import java.util.*;

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

