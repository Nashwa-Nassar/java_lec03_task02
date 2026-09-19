package com.depi.shopping;

import java.util.ArrayList;
import java.util.List;

/**
 * A store customer who can own one or more carts and, once those
 * carts are checked out, one or more bills.
 *
 * Composition: a Customer has-a List<Cart> and has-a List<Bill>.
 */
public class Customer {

    private int id;
    private String name;
    private List<Cart> carts; // composition: Customer has-a list of Carts
    private List<Bill> bills; // composition: Customer has-a list of Bills

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.carts = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    /** Creates a new empty cart owned by this customer, and tracks it. */
    public Cart createCart(int cartId) {
        Cart cart = new Cart(cartId, this);
        carts.add(cart);
        return cart;
    }

    /** Generates a Bill from the given cart and tracks it against this customer. */
    public Bill checkout(int billId, Cart cart) {
        Bill bill = new Bill(billId, cart);
        bills.add(bill);
        return bill;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public List<Bill> getBills() {
        return bills;
    }

    @Override
    public String toString() {
        return name;
    }
}
