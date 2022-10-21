package com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.productUnit;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.product.Product;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.List;

@Entity
@Table(name = "product_Unit")
public class ProductUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_Id")
    private int unitId;
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_Id")
    private Product product;

    public ProductUnit() {
    }

    public ProductUnit(int unitId, String name) {
        this.unitId = unitId;
        this.name = name;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "ProductUnit{" +
                "unitId=" + unitId +
                ", name='" + name + '\'' +
                '}';
    }
}
