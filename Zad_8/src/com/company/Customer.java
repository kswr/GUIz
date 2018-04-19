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

    public void pay(boolean cash) {
        for (int i = 0; i<shoppingCart.getShoppingCart().size();i++) {
            String name = shoppingCart.getShoppingCart().get(i).getName();
            double price = pl.getPrice(shoppingCart.getShoppingCart().get(i));
            if (price == -1.0) {
                shoppingCart.getShoppingCart().remove(i);
                i--;
            } else {
                int amount = shoppingCart.getShoppingCart().get(i).getAmount();
                double money = price * amount;
                if (!cash) {
                    if ((this.money - (money*1.01))>0){
                        this.money -= (money*1.01);
                    } else {
                       shoppingCart.getShoppingCart().remove(i);
                       i--;
                    }
                } else {
                    if ((this.money - money)>0){
                        this.money -= money;
                    } else {
                        shoppingCart.getShoppingCart().remove(i);
                        i--;
                    }
                }
            }
        }
    }

    public void pack(Box box) {
       for (int i = box.getBox().size()-1; i > -1; i--){
           shoppingCart.getShoppingCart().remove(box.getBox().get(i));
       }
    }


}
