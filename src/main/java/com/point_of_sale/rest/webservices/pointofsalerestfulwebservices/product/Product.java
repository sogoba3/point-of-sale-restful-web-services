package com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.productCategory.ProductCategory;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.productUnit.ProductUnit;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.receiveProduct.ReceiveProduct;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_Id")
    private int productId;

    @Column(name = "code")
    private long code;
    @Column(name = "name")
    private String name;

    @Column(name = "unit_Price")
    private double unitPrice;

    @Column(name = "unit_In_Stock")
    private int unitInStock;

    @Column(name = "discount_Percentage")
    private int discountPercentage;

    @OneToMany(mappedBy = "product")
    private List<ProductUnit> productUnit = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="category_Id", nullable = false)
    @JsonBackReference
    private ProductCategory productCategory;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_Id")
//    @JsonBackReference
//    private User user;

    @OneToMany(mappedBy = "product")
    private List<ReceiveProduct> receiveProduct = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return code == product.code;
    }


    public Product() {
    }

    public Product( long code, String name, double unitPrice, int unitInStock, int discountPercentage) {
//        this.productId = productId;
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.discountPercentage = discountPercentage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }


    @JsonManagedReference
    public List<ProductUnit> getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(List<ProductUnit> productUnit) {
        this.productUnit = productUnit;
    }

//    @JsonManagedReference
    @JsonBackReference
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @JsonManagedReference
    public List<ReceiveProduct> getReceiveProduct() {
        return receiveProduct;
    }

    public void setReceiveProduct(List<ReceiveProduct> receiveProduct) {
        this.receiveProduct = receiveProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitInStock=" + unitInStock +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
