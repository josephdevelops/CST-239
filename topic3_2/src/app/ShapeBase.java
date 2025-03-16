package app;

/**
 * The ShapeBase class serves as a base class for different geometric shapes.
 * It implements the ShapeInterface and provides common attributes like name, width, and height.
 */
public class ShapeBase implements ShapeInterface {
    /** The name of the shape. */
    protected String name;

    /** The width of the shape. */
    protected int width;

    /** The height of the shape. */
    protected int height;

    /**
     * Constructs a ShapeBase object with a given name, width, and height.
     *
     * @param name  The name of the shape.
     * @param width  The width of the shape.
     * @param height The height of the shape.
     */
    public ShapeBase(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    /**
     * Retrieves the name of the shape.
     *
     * @return The name of the shape.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Calculates the area of the shape.
     * This method is overridden in subclasses to provide shape-specific calculations.
     *
     * @return -1 as a placeholder value, since ShapeBase itself does not represent a specific shape.
     */
    @Override
    public int calculateArea() {
        return -1;
    }
}