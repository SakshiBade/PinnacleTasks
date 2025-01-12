import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class CartItem {
    private Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    public void updateQuantity(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.quantity = quantity;
                break;
            }
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public List<CartItem> getItems() {
        return items;
    }
}

public class ECommerce {
    public static void main(String[] args) {
        // Sample Products
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Mouse", 20.00);
        Product product3 = new Product("Keyboard", 50.00);

        // Create a Shopping Cart
        ShoppingCart cart = new ShoppingCart();

        // Add items to the cart
        cart.addItem(product1, 1);
        cart.addItem(product2, 2);
        cart.addItem(product3, 1);

        // Update quantity of an item
        cart.updateQuantity(product2, 3);

        // Remove an item from the cart
        // cart.removeItem(product3);

        // Display Cart Items
        System.out.println("Shopping Cart:");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getProduct().getName() + " - " + item.getQuantity() + " - $" + item.getTotalPrice());
        }

        // Calculate and display total price
        System.out.println("Total Price: $" + cart.getTotalPrice());

        // Checkout (Simulated)
        System.out.println("Checkout successful!");
    }
}