package app;

import java.util.Random;

public class SuperHero {
    private String name;
    private int health;
    private boolean isDead;

    // Constructor
    public SuperHero(String name, int health) {
        this.name = name;
        this.health = health;
        this.isDead = false;
    }

    // Attack method
    public void attack(SuperHero opponent) {
        Random rand = new Random();
        int damage = rand.nextInt(10) + 1; // Random damage between 1 and 10
        opponent.determineHealth(damage);
        System.out.println(this.name + " attacks " + opponent.name + " for " + damage + " damage. " + opponent.name + " health: " + opponent.health);
    }

    // Check if dead
    public boolean isDead() {
        return isDead;
    }

    // Adjust health after attack
    private void determineHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            this.isDead = true;
        }
    }

    // Unique power method (to be overridden in subclasses)
    public void usePower() {
        System.out.println(name + " has no special power.");
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for health
    public int getHealth() {
        return health;
    }

    // Setter for health (for power abilities)
    protected void setHealth(int health) {
        this.health = health;
    }
}


//package app;
//
//import java.util.Random;
//
//public class SuperHero {
//    private String name;
//    private int health;
//    private boolean isDead;
//
//    // Constructor
//    public SuperHero(String name, int health) {
//        this.name = name;
//        this.health = health;
//        this.isDead = false;
//    }
//
//    // Attack method
//    public void attack(SuperHero opponent) {
//        Random rand = new Random();
//        int damage = rand.nextInt(10) + 1; // Random damage between 1 and 10
//        opponent.determineHealth(damage);
//        System.out.println(this.name + " attacks " + opponent.name + " for " + damage + " damage. " + opponent.name + " health: " + opponent.health);
//    }
//
//    // Check if dead
//    public boolean isDead() {
//        return isDead;
//    }
//
//    // Adjust health after attack
//    private void determineHealth(int damage) {
//        this.health -= damage;
//        if (this.health <= 0) {
//            this.health = 0;
//            this.isDead = true;
//        }
//    }
//}