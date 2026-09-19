# Shopping System

**DEPI – Software Testing Track | Part 01: Java Fundamentals**
Instructor: Mina Younan — Session 04, Assignment 03

A Java OOP design and implementation of a simple store shopping flow,
built around exactly four classes — `Item`, `Cart`, `Bill`, and
`Customer` — that let a customer add items to a cart and generate a
bill showing every item, its quantity, price, and the total amount.

## Class design

### `Item`
Attributes: `id` (int), `name` (String), `price` (double), `quantity` (int)
Methods: constructor, getters/setters, `increaseQuantity(int)`, `getSubtotal()` (`price * quantity`), `toString()`
Represents a product plus how many units of it are in a given cart — kept on `Item` itself since the design uses exactly four classes (no separate cart-line class).

### `Cart`
Attributes: `id` (int), `owner` (`Customer`), `items` (`List<Item>`)
Methods: constructor, `addItem(Item)` (merges quantities if the item is already in the cart), `removeItem(Item)`, `calculateTotal()`, getters
**Composition:** a `Cart` has-a `Customer` (its owner) and has-a `List<Item>`.

### `Bill`
Attributes: `id` (int), `cart` (`Cart`), `totalAmount` (double), `issuedAt` (`LocalDateTime`)
Methods: constructor, `generateTotal()`, `printBill()` (prints every item/qty/price/subtotal plus the total), getters
**Composition:** a `Bill` has-a `Cart` — it's generated from that cart's contents.

### `Customer`
Attributes: `id` (int), `name` (String), `carts` (`List<Cart>`), `bills` (`List<Bill>`)
Methods: constructor, `createCart(int)`, `checkout(int, Cart)` (generates and tracks a `Bill`), getters/setters
**Composition:** a `Customer` has-a `List<Cart>` and a `List<Bill>` — a customer can own more than one of each.

Every collection required by the design (`Cart.items`, `Customer.carts`,
`Customer.bills`) is implemented as an `ArrayList`.

## How a purchase flows

1. A `Customer` calls `createCart()` to get a new `Cart` linked back to them.
2. Items are added to the cart with `cart.addItem(item)`; adding an
   item that's already there increases its quantity instead of
   duplicating the line.
3. `cart.calculateTotal()` sums every item's `price * quantity`.
4. `customer.checkout(billId, cart)` generates a `Bill` from the cart
   and records it against the customer.
5. `bill.printBill()` prints a receipt: each item, quantity, price,
   subtotal, and the grand total.

## Project structure

```
shopping-system/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── depi/
                    └── shopping/
                        ├── Item.java
                        ├── Cart.java
                        ├── Bill.java
                        ├── Customer.java
                        └── Main.java   # demo: one customer, two carts, two bills
```

## Requirements

- Java 11+
- Maven 3.6+

## Build & run

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.depi.shopping.Main"

# or
mvn package
java -jar target/shopping-system.jar
```

## License

Coursework project for the DEPI Software Testing Track — free to use
for learning and reference.
