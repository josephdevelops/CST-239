package app;

import java.util.Random;

public class Superman extends SuperHero {
    private boolean usedResurrection = false;

    public Superman() {
        super("Superman", new Random().nextInt(1000) + 1);
    }

    // Superman’s unique power: Resurrection (revives with 50 health if he dies)
    @Override
    public void usePower() {
        if (isDead() && !usedResurrection) {
            System.out.println("Superman activates Resurrection! Revives with 50 health.");
            usedResurrection = true;
            setHealth(50);
        }
    }
}


//package app;
//
//import java.util.Random;
//
//public class Superman extends SuperHero {
//    public Superman() {
//        super("Superman", new Random().nextInt(1000) + 1);
//    }
//} /* Page 2-3 Health */