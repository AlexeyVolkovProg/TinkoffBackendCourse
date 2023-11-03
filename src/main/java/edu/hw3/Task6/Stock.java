package edu.hw3.Task6;

public class Stock {
    private final String name;
    private final double price;

    public Stock(String symbol, double price) {
        this.name = symbol;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
