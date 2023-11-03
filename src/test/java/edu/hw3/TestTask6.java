package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import edu.hw3.Task6.StockMarketImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask6 {
    @Test
    public void testStockMarket() {
        StockMarket stockMarket = new StockMarketImpl();

        stockMarket.add(new Stock("SBER", 151.50));
        stockMarket.add(new Stock("GAZPROM", 2700.75));
        stockMarket.add(new Stock("YANDEX", 820.20));
        Stock mostValuable = stockMarket.mostValuableStock();
        assertEquals(2700.75, mostValuable.getPrice());
    }
}
