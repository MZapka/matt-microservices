package mz.zapps.services.cart.model;

import javax.persistence.*;

@Entity
@Table(name="CART")
public class Cart {

    @Id
    @JoinColumn(name="cartID", referencedColumnName = "CARTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartID;

//    @Column(name = "CUSTOMER_ID")

    @JoinColumn(name="customerID", referencedColumnName = "CUSTOMERID")
    private Long customerID;

//    @Column(name = "PRODUCT_ID")

    @JoinColumn(name="productID", referencedColumnName = "PRODUCTID")
    private Long productID;

    @Column(name = "QUANTITY")
    private int quantity;

    public Cart() {}

    public Cart(Long customerID, Long productID, int quantity) {
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
