package app;

/**
 * The {@code Game} class serves as the main entry point for the application.
 * It demonstrates polymorphism by creating an array of {@code WeaponInterface} objects,
 * instantiating a {@code Bomb} and a {@code Gun}, and then firing them using the {@code fireWeapon} method.
 * This class illustrates how dynamic method dispatch is used in Java to call the appropriate implementation
 * of methods defined in an interface.
 * 
 * @author 
 * @version 1.0
 */
public class Game {

    /**
     * The main method initializes the array of weapons and demonstrates their functionality.
     * It creates a {@code Bomb} and a {@code Gun}, then iterates through the array to fire each weapon.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        WeaponInterface[] weapons = new WeaponInterface[2];
        weapons[0] = new Bomb();
        weapons[1] = new Gun();
        
        for (int x = 0; x < weapons.length; ++x) {
            fireWeapon(weapons[x]);
        }
    }
    
    /**
     * Fires the given weapon by activating it and calling its {@code fireWeapon(int power)} method.
     * If the weapon is an instance of {@code Bomb}, a special message is printed before firing.
     *
     * @param weapon The weapon to be fired.
     */
    private static void fireWeapon(WeaponInterface weapon) {
        if (weapon instanceof Bomb) {
            System.out.println("---------> I am a bomb");
        }
    
        weapon.activate(true);
        weapon.fireWeapon(5);
    }
}