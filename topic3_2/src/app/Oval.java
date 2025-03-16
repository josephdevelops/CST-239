package app;

public class Oval extends ShapeBase {
	
	public Oval ( String name, int width, int height) {
		super(name, width, height);
	}

	@Override
	public int calculateArea() {
		//on this one I used Math.PI
		//on the circle I used 3.14
		return (int) Math.round((width+height)/2 * Math.PI);
	}

}