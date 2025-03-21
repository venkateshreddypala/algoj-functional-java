package kafka.model;

public class Order {
    public String orderId;
    public String product;
    public int quantity;

    public Order(String orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Order[id=%s, product=%s, quantity=%d]", orderId, product, quantity);
    }
}