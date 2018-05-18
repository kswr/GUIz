package com.company;

import java.util.ArrayList;

public class PriceList {
    private static PriceList instance = new PriceList();
    private ArrayList<Object[]> priceList = new ArrayList<>();

    private PriceList() {
    }

    public static PriceList getInstance() {
        return instance;
    }

    public void put(String name, double detPrice, int minHurt, double hurtPrice) {
        Object[] tempArr =  {name,detPrice,minHurt,hurtPrice};
        priceList.add(tempArr);
    }

    public void put(String name, double detPrice) {
        Object[] tempArr =  {name,detPrice, -1, -1.0};
        priceList.add(tempArr);
    }

    // testowa, nieużywana w kodzie
    @Override
    public String toString() {
        String tempStr = "";
        for (int i =0; i<priceList.size();i++) {
            tempStr += (priceList.get(i)[0]+"\n");
        }
        return tempStr;
    }

    public double getPrice(Flower flower) {
        double price = -1.0;
        String name = flower.getName();
        for (int i = 0; i < priceList.size();i++) {
            if (priceList.get(i)[0] == name) {
                if ((((int) priceList.get(i)[2])>-1) & (flower.getAmount()>((int)priceList.get(i)[2]))) {
                    price = (double) priceList.get(i)[3];
                } else {
                    price = (double) priceList.get(i)[1];
                }
            }
        }
        return price;
    }
}
