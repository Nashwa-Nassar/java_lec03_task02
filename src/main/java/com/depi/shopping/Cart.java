package com.depi.shopping;

import java.util.ArrayList;
import java.util.List;

/**
 * A shopping cart that belongs to exactly one Customer and holds a
 * list of Items (each already carrying its own quantity).
 *
 * Composition: a Cart has-a Customer (the owner) and has-a
 * List<Item> (the items placed in it).
 */
public class Cart {

    private int id;
    private Customer owner;   // composition: Cart has-a Customer
    private List<Item> items; // composition: Cart has-a list of Items

    public Cart(int id, Customer owner) {
        this.id = id;
        this.owner = owner;
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the cart. If an item with the same id is already
     * present, its quantity is increased instead of adding a duplicate line.
     */
    public void addItem(Item item) {
        for (Item existing : items) {
            if (existing.equals(item)) {
                existing.increaseQuantity(item.getQuantity());
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getId() {
        return id;
    }

    public Customer getOwner() {
        return owner;
    }

    public List<Item> getItems() {
        return items;
    }

    /** Sum of every item's subtotal (price * quantity) currently in the cart. */
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart #" + id + " (" + owner.getName() + ") - " + items.size() + " item(s)";
    }
}
