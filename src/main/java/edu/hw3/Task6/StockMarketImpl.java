package edu.hw3.Task6;

import java.util.PriorityQueue;
import java.util.Queue;

public class StockMarketImpl implements StockMarket {

    private final Queue<Stock> stockQueue;

    public StockMarketImpl() {
        stockQueue = new PriorityQueue<>((stock1, stock2) -> Double.compare(stock2.getPrice(), stock1.getPrice()));
    }

    @Override
    public void add(Stock stock) {
        stockQueue.offer(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockQueue.peek();
    }

}
