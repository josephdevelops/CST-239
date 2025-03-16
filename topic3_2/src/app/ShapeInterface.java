package app;

/**
 * The {@code ShapeInterface} defines a contract for shape-related classes.
 * Any class that implements this interface must provide an implementation for the {@code calculateArea()} method.
 *
 * <p>This interface is designed to be implemented by various geometric shape classes,
 * ensuring that each shape can compute its own area.</p>
 * 
 * @author [Your Name]
 * @version 1.0
 */
public interface ShapeInterface {

    /**
     * Calculates the area of the shape.
     * Implementing classes should provide their specific formula for calculating the area.
     *
     * @return The calculated area of the shape.
     */
    int calculateArea();
}