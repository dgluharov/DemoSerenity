package com.qualityhouse.serenity.entities;

public class Product {
    private String name;
    private int quantity;
    private String size;
    private String color;
    private double unitPrice;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double price) {
        this.unitPrice = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + unitPrice +
                '}';
    }
}
