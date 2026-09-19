package com.depi.shopping;

import java.time.LocalDateTime;

/**
 * A bill generated from a finished Cart, showing all its items,
 * quantities, prices, and the total amount to pay.
 *
 * Composition: a Bill has-a Cart (the cart it was generated from).
 */
public class Bill {

    private int id;
    private Cart cart;      // composition: Bill has-a Cart
    private double totalAmount;
    private LocalDateTime issuedAt;

    public Bill(int id, Cart cart) {
        this.id = id;
        this.cart = cart;
        this.issuedAt = LocalDateTime.now();
        this.totalAmount = generateTotal();
    }

    /** Recalculates the total amount from the cart's current items. */
    public double generateTotal() {
        this.totalAmount = cart.calculateTotal();
        return this.totalAmount;
    }

    public int getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    /** Prints a readable receipt: every item, its quantity, price, and the total. */
    public void printBill() {
        System.out.println("----- Bill #" + id + " -----");
        System.out.println("Customer: " + cart.getOwner().getName());
        for (Item item : cart.getItems()) {
            System.out.println(String.format("  %-15s qty:%-3d price:%-8.2f subtotal:%-8.2f",
                    item.getName(), item.getQuantity(), item.getPrice(), item.getSubtotal()));
        }
        System.out.println("Total: " + totalAmount);
        System.out.println("-------------------------");
    }

    @Override
    public String toString() {
        return "Bill #" + id + " for " + cart.getOwner().getName() + " - Total: " + totalAmount;
    }
}
