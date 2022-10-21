package com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.product.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private int userId;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "contact")
    private String contact;

    @Column(name = "designation")
    private String designation;

    @Column(name = "account_Type")
    private String accountType;

    @Column(name = "user_Name")
    private String userName;
    @Column(name = "pass_Word")
    private String password;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
////    @JsonBackReference
//    @JsonManagedReference
//    private List<Product> product;

    public User() {
    }

    public User(int userId, String firstName, String lastName, String contact, String designation, String accountType, String userName, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.designation = designation;
        this.accountType = accountType;
        this.userName = userName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Product> getProduct() {
//        return product;
//    }
//
//    public void setProduct(List<Product> product) {
//        this.product = product;
//    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", designation='" + designation + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
