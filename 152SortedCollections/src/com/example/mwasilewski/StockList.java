package com.example.mwasilewski;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    /**
     * Adds stock to the list. If the item (of the same name) is already in the list, it just appends its quantity.
     *
     * @param item item to be added to list
     * @return quantity of the item or -1 if the item is null.
     */
    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());

            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return -1;
    }

    /**
     * Removes quantity of item from the stock list.
     * Only if the item exists, the quantity is greater than 0 but not exceeding the quantity in stock.
     *
     * @param item     item to be sold.
     * @param quantity number of items to be sold.
     * @return quantity of sold item.
     */
    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if (inStock != null && inStock.quantityInStock() >= quantity && quantity > 0) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach((k, v) -> stringBuilder.append("Item: ").append(k).append("\n\tquantity: ")
                .append(v.quantityInStock()).append("\n\tvalue: ")
                .append(String.format("%.2f",v.quantityInStock() * v.getPrice())).append(".\n"));
        stringBuilder.append("Total value: ").append(String.format("%.2f",
                list.values().stream().map(v -> v.getPrice() * v.quantityInStock())
                        .reduce(0.0, (a, b) -> a + b)));
        return stringBuilder.toString();
    }
}
