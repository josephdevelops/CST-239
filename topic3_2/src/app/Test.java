package app;

/**
 * The {@code Test} class demonstrates the use of polymorphism with different shape types.
 * It initializes an array of various shapes and calculates their areas.
 *
 * <p>This class serves as the entry point of the program, showcasing how different 
 * shape objects (Rectangle, Triangle, Circle, and Oval) can be stored in an array 
 * and processed uniformly through the {@code displayArea()} method.</p>
 *
 * @author [Your Name]
 * @version 1.0
 */
public class Test {

    /**
     * The main method serves as the entry point of the program.
     * It initializes an array of {@code ShapeBase} objects with different shape instances,
     * then iterates through them to display their areas.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Circle/oval area is rounded to integer. \n");

        // Creating an array of shapes
        ShapeBase[] shapes = new ShapeBase[4];
        shapes[0] = new Rectangle("Rectangle", 10, 200);
        shapes[1] = new Triangle("Triangle", 10, 50);
        shapes[2] = new Circle("Circle", 10, 10);
        shapes[3] = new Oval("Oval", 10, 10);

        // Iterating through shapes and displaying their area
        for (int x = 0; x < shapes.length; ++x) {
            displayArea(shapes[x]);
        }
    }

    /**
     * Displays the area of a given shape.
     * This method takes a {@code ShapeBase} object, retrieves its name and calculated area,
     * and prints the information to the console.
     *
     * @param shape The shape whose area will be displayed.
     */
    public static void displayArea(ShapeBase shape) {
        System.out.println("This is shape name " + shape.getName() 
            + " with an area of " + shape.calculateArea());
    }
}