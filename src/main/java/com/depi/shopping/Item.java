package com.depi.shopping;

/**
 * Represents a single product that can be bought, and the quantity of
 * it that has been added to a cart. Since the assignment requires
 * exactly four classes (no separate "CartLine" class), the quantity
 * for "how many of this item" lives directly on the Item itself.
 *
 * An Item is used as an element inside a Cart's item list
 * (composition: Cart has-a List<Item>).
 */
public class Item {

    private int id;
    private String name;
    private double price;
    private int quantity;

    public Item(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    /** price * quantity for this line. */
    public double getSubtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " x" + quantity + " @ " + price + " = " + getSubtotal();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        return id == ((Item) o).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
