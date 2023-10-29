package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {
    @Test
    public void squareTest() {
        var square = (Rectangle) new Square(9);

        assertEquals(square.area(), 81);

        square = square.setWidth(6);
        assertEquals(square.area(), 36);

        square = square.setHeight(7);
        assertEquals(square.area(), 49);
    }
    @Test
    public void rectangleTest() {
        var rectangle = new Rectangle(10, 9);

        assertEquals(rectangle.area(), 90);

        rectangle = rectangle.setWidth(6);
        assertEquals(rectangle.area(), 54);

        rectangle = rectangle.setHeight(7);
        assertEquals(rectangle.area(), 42);
    }

}
