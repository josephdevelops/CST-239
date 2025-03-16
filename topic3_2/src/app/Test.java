package app;

public class Test {
	
	public static void main(String[] args) {
		
		System.out.println("Circle/oval area is rounded to integer. \n");
		
		
		ShapeBase[] shapes = new ShapeBase [4];
		shapes[0] = new Rectangle("Rectangle", 10, 200);
		shapes[1] = new Triangle("Triangle", 10, 50);
		shapes[2] = new Circle("Circle", 10, 10);
		shapes[3] = new Oval("Oval", 10, 10);
		
		for(int x=0; x < shapes.length;++x) {
			displayArea(shapes[x]);
		}
		
		
	}

	public static void displayArea(ShapeBase shape) {
		
		System.out.println("This is shape name " + shape.getName() 
		+ " with an area of " + shape.calculateArea());
		
	}
	

}
