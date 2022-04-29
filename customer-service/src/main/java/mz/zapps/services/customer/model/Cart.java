package mz.zapps.services.customer.model;

import javax.persistence.*;

public class Cart {

    private Long cartID;

    private Long customerID;

    private Long productID;

    private int quantity;

    public Cart() {}

    public Cart(Long cartID, Long customerID, Long productID, int quantity) {
        this.cartID = cartID;
        this.customerID = customerID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public Long getCartID() {
        return cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", customerID=" + customerID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                '}';
    }
}
