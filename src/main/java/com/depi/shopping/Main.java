package com.depi.shopping;

/**
 * DEPI - Software Testing Track - Session 04 - Assignment 03
 * Java OOP Assignment - Shopping System in a Store
 *
 * Demo entry point wiring the four required classes together
 * (Item, Cart, Bill, Customer) end-to-end.
 */
public class Main {

    public static void main(String[] args) {
        // ---- 1) Create a customer ----
        Customer customer = new Customer(1, "Nashwa Nassar");

        // ---- 2) Customer creates a cart ----
        Cart cart = customer.createCart(101);

        // ---- 3) Add items (with quantities) to the cart ----
        cart.addItem(new Item(1, "Notebook", 25.0, 3));
        cart.addItem(new Item(2, "Pen", 5.0, 5));
        cart.addItem(new Item(3, "Backpack", 450.0, 1));

        // Adding more of an item already in the cart increases its quantity
        cart.addItem(new Item(1, "Notebook", 25.0, 2)); // now 5 notebooks total

        System.out.println(cart);
        System.out.println("Cart total before checkout: " + cart.calculateTotal());
        System.out.println();

        // ---- 4) Checkout: generate a bill from the cart ----
        Bill bill = customer.checkout(9001, cart);
        bill.printBill();

        // ---- 5) A customer can own more than one cart/bill ----
        Cart secondCart = customer.createCart(102);
        secondCart.addItem(new Item(4, "Desk Lamp", 300.0, 1));
        Bill secondBill = customer.checkout(9002, secondCart);

        System.out.println();
        System.out.println(customer.getName() + " has " + customer.getCarts().size()
                + " cart(s) and " + customer.getBills().size() + " bill(s).");
        secondBill.printBill();
    }
}
