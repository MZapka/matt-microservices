package mz.zapps.services.cart.model;


public class Product {


    private Long productID;
    private String productName;
    private int supplierID;
    private Long categoryID;
    private Long unitPrice;


    // Constructors

    public Product() {
    }

    public Product(String productName, int supplierID, Long categoryID, Long unitPrice) {
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.unitPrice = unitPrice;
    }

    // Accessors & Mutators

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }


    // toString

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", supplierID=" + supplierID +
                ", categoryID=" + categoryID +
                ", unitPrice=" + unitPrice +
                '}';
    }
}


