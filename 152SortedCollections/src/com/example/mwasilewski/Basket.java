package com.example.mwasilewski;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }
    public int checkout(StockItem item)
    {
        if(item!=null && list.containsKey(item))
        {
            System.out.println(item.getName()+" checked out from basket.");
            list.remove(item);
            return 0;
        }
        return -1;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Basket: ").append(name).append(":\n");
        list.forEach((k, v) -> stringBuilder.append("Item: ").append(k.getName()).append("\tquantity: ")
                .append(v).append(".\n"));
        stringBuilder.append("Total cost: ").append(list.entrySet().stream().map(v->v.getKey().getPrice()*v.getValue()).reduce(0.0,(a,b)->a+b));
        return stringBuilder.toString();
    }
}
