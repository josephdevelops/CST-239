package app;

public class Circle extends ShapeBase {
	
	public Circle ( String name, int width, int height) {
		super(name, width, height);
	}

	@Override
	public int calculateArea() {
		return (int) Math.round(width * 3.14);
	}

}
