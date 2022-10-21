package com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.receiveProduct;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.product.Product;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "receive_Product")
public class ReceiveProduct{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receive_Product_Id")
    private int receiveProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_Id")
    private Product product;

    @Column(name = "quantity")
    private int quantity = 0;

    @Column(name = "unit_Price")
    private double unitPrice;
    @Column(name = "sub_Total")
    private double subTotal;

    @Column(name = "received_Date")
    @CreationTimestamp
    private LocalDateTime receivedDate;

    public ReceiveProduct() {
    }

    public ReceiveProduct(int receiveProductId, int quantity, double unitPrice, double subTotal, LocalDateTime receivedDate) {
        this.receiveProductId = receiveProductId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
        this.receivedDate = receivedDate;
    }

    public int getReceiveProductId() {
        return receiveProductId;
    }

    public void setReceiveProductId(int receiveProductId) {
        this.receiveProductId = receiveProductId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public LocalDateTime getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDateTime receivedDate) {
        this.receivedDate = receivedDate;
    }

    @JsonBackReference
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ReceiveProduct{" +
                "receiveProductId=" + receiveProductId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subTotal=" + subTotal +
                ", receivedDate=" + receivedDate +
                '}';
    }
}
