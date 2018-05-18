package com.company;

import java.util.ArrayList;


public class ShoppingCart{
    String owner;
    private ArrayList<Flower> shoppingCart = new ArrayList<>();
    PriceList pl = PriceList.getInstance();

    public ShoppingCart() {
        this("");
    }

    public ShoppingCart(String owner) {
        this.owner = owner;
    }


    public void addToShoppingCart(Flower flower) {
        shoppingCart.add(flower);
    }

    public ArrayList<Flower> getShoppingCart() {
        return shoppingCart;
    }

    // todo customise to work the intended way
    @Override
    public String toString() {
        String tempStr = "";
        if (shoppingCart.size()>0) {
            tempStr += ("Wózek właściciela " + owner + "\n");
        } else {
            tempStr += ("Wózek właściciela " + owner + " -- pusto \n");
        }
        for (int i=0; i<shoppingCart.size(); i++) {
            tempStr += (shoppingCart.get(i).getName() + ", kolor: " + shoppingCart.get(i).getColor() + ", ilość " + shoppingCart.get(i).getAmount() + ", cena " + pl.getPrice(shoppingCart.get(i)) + "\n");
        }
        return tempStr;
    }


}
