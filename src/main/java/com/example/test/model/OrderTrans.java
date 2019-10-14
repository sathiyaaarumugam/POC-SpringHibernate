package com.example.test.model;

import javax.persistence.*;

@Entity
@Table (name="order_trans")
public class OrderTrans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", updatable = false, nullable = false)
    private int orderId;

    @Column (name="order_status")
    private String orderStatus;

    @Column (name="product")
    private String product_name;

    @Column (name="product_price")
    private int productPrice;

    @Column (name="purchase_date")
    private String purchaseDate;

    @Column (name="cust_id")
    private int custId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }
    public OrderTrans(){

    }
    public OrderTrans(String orderStatus, String product_name, int productPrice, String purchaseDate, int custId) {
        this.orderStatus = orderStatus;
        this.product_name = product_name;
        this.productPrice = productPrice;
        this.purchaseDate = purchaseDate;
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "OrderTrans{" +
                "orderId=" + orderId +
                ", orderStatus='" + orderStatus + '\'' +
                ", product_name='" + product_name + '\'' +
                ", productPrice=" + productPrice +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", custId=" + custId +
                '}';
    }
}
