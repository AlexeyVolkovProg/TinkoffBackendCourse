package edu.hw2.Task2;

public class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }

    @Override public Rectangle setWidth(int width) {
        return new Square(width);
    }

    @Override public Rectangle setHeight(int height) {
        return new Square(height);
    }
}
