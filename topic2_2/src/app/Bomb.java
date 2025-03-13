package app;

public class Bomb extends Weapon {
	
	  @Override public void fireWeapon(int power) {
	  System.out.println("Bomb exploding with power: " + power); }
	  
	  public void fireWeapon() { System.out.println("Bomb activated!");
	  super.fireWeapon(50); }
	  
	  
	  @Override public void activate(boolean enable) {
	  System.out.println("Bomb activation: " + enable); }
	 
}