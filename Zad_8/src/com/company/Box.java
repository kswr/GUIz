package com.company;

import java.util.ArrayList;

public class Box {
    private ArrayList<Flower> box = new ArrayList<>();
    private String owner;
    PriceList pl = PriceList.getInstance();

    public ArrayList<Flower> getBox() {
        return box;
    }

    public Box(Customer customer) {
//        this.box = new ArrayList<Flower>();
        this.box.addAll(customer.getShoppingCart().getShoppingCart());
        this.owner = customer.getName();
    }

    @Override
    public String toString() {
        String tempStr = "";
        if (box.size()>0) {
            tempStr += ("Pudełko właściciela " + owner + "\n");
        } else {
            tempStr += ("Pudełko właściciela " + owner + " -- pusto \n");
        }
        for (int i=0; i<box.size(); i++) {
            tempStr += (box.get(i).getName() + ", kolor: " + box.get(i).getColor() + ", ilość " + box.get(i).getAmount() + ", cena " + pl.getPrice(box.get(i)) + "\n");
        }
        return tempStr;
    }
}
