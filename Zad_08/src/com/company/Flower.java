package com.company;

public class Flower {
    private String name;
    private String color;
    private int amount;

    public Flower(String name, String color, int amount) {
        this.name = name;
        this.color = color;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAmount() {
        return amount;
    }

}
