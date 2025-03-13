package app;

public abstract class Weapon {
    public void fireWeapon(int power) {
        System.out.println(getClass().getSimpleName() + " firing with power: " + power);
    }

    public abstract void activate(boolean enable);
} 