package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private double money;
    private ShoppingCart shoppingCart = new ShoppingCart();
    PriceList pl = PriceList.getInstance();

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
        shoppingCart.owner = name;
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return money;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void get(Flower flower) {
        this.shoppingCart.addToShoppingCart(flower);
    }

    public void pay(boolean card) {
        for (int i = 0; i<shoppingCart.getShoppingCart().size();i++) {
            String name = shoppingCart.getShoppingCart().get(i).getName();
            double price = pl.getPrice(shoppingCart.getShoppingCart().get(i));
            if (price == -1.0) {
                shoppingCart.getShoppingCart().remove(i);
                i--;
            } else {
                int amount = shoppingCart.getShoppingCart().get(i).getAmount();
                double money = price * amount;
                if (!card) {
                    this.money -= (money*1.23);
                } else {
                    this.money -= money;
                }
            }
        }
    }

    public void pack(Box box) {
       for (int i = 0; i < box.getBox().size(); ){
           shoppingCart.getShoppingCart().remove(box.getBox().get(i));
       }
    }


}
