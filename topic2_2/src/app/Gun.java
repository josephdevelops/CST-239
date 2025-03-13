package app;

public class Gun extends Weapon { 
	
@Override 
	public void fireWeapon(int power) {
	  System.out.println("Gun shooting with power: " + power); }
	 

    public void fireWeapon() {
        System.out.println("Gun activated!");
        super.fireWeapon(10);
    }

	
@Override 
	public void activate(boolean enable) {
	  System.out.println("Gun activation: " + enable); }
	 
} 