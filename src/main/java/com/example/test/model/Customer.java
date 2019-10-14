package com.example.test.model;

import javax.persistence.*;

@Entity
@Table(name="cust_tbl")
@Inheritance(strategy=InheritanceType.JOINED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cust_id", updatable = false, nullable = false)
    private int custId;

    @Column (name="cust_firstname")
    private String custFirstName;

    @Column (name="cust_surname")
    private String custLastName;

    @Column (name="cust_address")
    private String custAddress;

    @Column (name="cust_type")
    private String custType;

    @Column (name="cust_mobile")
    private String custMobile;

public Customer(){

}

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public Customer(String custFirstName, String custLastName, String custAddress, String custType, String custMobile) {
        this.custFirstName = custFirstName;
        this.custLastName = custLastName;
        this.custAddress = custAddress;
        this.custType = custType;
        this.custMobile = custMobile;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custFirstName='" + custFirstName + '\'' +
                ", custLastName='" + custLastName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custType='" + custType + '\'' +
                ", custMobile='" + custMobile + '\'' +
                '}';
    }
}
