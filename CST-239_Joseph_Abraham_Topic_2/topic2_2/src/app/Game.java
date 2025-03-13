package app;

public class Game {
    public static void main(String[] args) {
        Weapon bomb = new Bomb();
        Weapon gun = new Gun();

        bomb.fireWeapon(100);
        gun.fireWeapon(30);

        bomb.activate(true);
        gun.activate(false);

        ((Bomb) bomb).fireWeapon();
        ((Gun) gun).fireWeapon();
    }
}