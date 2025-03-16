package app;

public class Triangle extends ShapeBase {
	
	public Triangle ( String name, int width, int height) {
		super(name, width, height);
	}

	@Override
	public int calculateArea() {
		return width * height/2;
	}
}