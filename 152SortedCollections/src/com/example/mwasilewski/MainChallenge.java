package com.example.mwasilewski;

public class MainChallenge {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 200);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);
        System.out.println(stockList);
        Basket m = new Basket("Maciek");
        reserveItem(m,"juice",36);
        reserveItem(m,"juice",27);
        System.out.println(stockList);
        checkoutBasket(m);
        System.out.println(stockList);
        System.out.println(m);
    }

    public static int reserveItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return -1;
        }
        if (stockList.reserveStock(item, quantity) != -1) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        System.out.println("We don't have enough number of " + item);
        return -1;
    }

    public static int checkoutBasket(Basket basket) {
        for (StockItem s : basket.Items().keySet()) {
            basket.checkout(s);
            stockList.sellStock(s.getName());
        }
        return 0;
    }
}
