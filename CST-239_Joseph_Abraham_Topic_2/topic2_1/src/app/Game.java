package app;

public class Game {
    public static void main(String[] args) {
        Batman batman = new Batman();
        Superman superman = new Superman();

        System.out.println("Batman starts with " + batman.getHealth() + " health.");
        System.out.println("Superman starts with " + superman.getHealth() + " health.");

        while (!batman.isDead() && !superman.isDead()) {
            superman.attack(batman);

            // Batman uses his power if his health drops below 200
            if (batman.getHealth() < 200 && !batman.isDead()) {
                batman.usePower();
            }

            if (!batman.isDead()) {
                batman.attack(superman);
            }

            // Superman uses resurrection if he dies
            if (superman.isDead()) {
                superman.usePower();
            }
        }

        System.out.println(batman.isDead() ? "Batman is defeated!" : "Superman is defeated!");
    }
}


//package app;
//
//public class Game {
//    public static void main(String[] args) {
//        Batman batman = new Batman();
//        Superman superman = new Superman();
//
//        System.out.println("Batman starts with " + batman.isDead());
//        System.out.println("Superman starts with " + superman.isDead());
//
//        while (!batman.isDead() && !superman.isDead()) {
//            superman.attack(batman);
//            if (!batman.isDead()) {
//                batman.attack(superman);
//            }
//        }
//
//        System.out.println(batman.isDead() ? "Batman is defeated!" : "Superman is defeated!");
//    }
//}