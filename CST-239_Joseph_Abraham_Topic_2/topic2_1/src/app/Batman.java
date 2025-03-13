package app;

import java.util.Random;

public class Batman extends SuperHero {
    public Batman() {
        super("Batman", new Random().nextInt(1000) + 1);
    }

    // Batman’s unique power: Help from Robin (restores 20 health)
    @Override
    public void usePower() {
        if (!isDead()) {
            System.out.println("Batman calls for Help from Robin! Restores 20 health.");
            setHealth(getHealth() + 20);
        }
    }
}

//package app;
//
//import java.util.Random;
//
//public class Batman extends SuperHero {
//    public Batman() {
//        super("Batman", new Random().nextInt(1000) + 1);
//    }
//}