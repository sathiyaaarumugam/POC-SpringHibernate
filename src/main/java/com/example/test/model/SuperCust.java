package com.example.test.model;

import javax.persistence.*;

@Entity
@Table(name="super_cust_tbl")
@PrimaryKeyJoinColumn(name = "cust_id")
public class SuperCust extends Customer{


    @Column (name="super_promo_code")
    private String superPromoCode;

    @Column (name="super_promo_end_date")
    private String superPromoEndDate;

    public SuperCust(String custFirstName, String custLastName, String custAddress, String custType, String custMobile) {
        super(custFirstName, custLastName, custAddress, custType, custMobile);
    }
    public SuperCust(){

    }


    public String getSuperPromoCode() {
        return superPromoCode;
    }

    public void setSuperPromoCode(String superPromoCode) {
        this.superPromoCode = superPromoCode;
    }

    public String getSuperPromoEndDate() {
        return superPromoEndDate;
    }


    public void setSuperPromoEndDate(String superPromoEndDate) {
        this.superPromoEndDate = superPromoEndDate;
    }

    @Override
    public String toString() {
        return "Super Customer{" +
                "customer Id=" + getCustId() +
                ", First Name='" + getCustFirstName() + '\'' +
                ", Last Name='" + getCustLastName() + '\'' +
                ", Address='" + getCustAddress() + '\'' +
                ", Type='" + getCustType() + '\'' +
                ", Mobile='" + getCustMobile() + '\'' +
                " PromoCode='" + superPromoCode + '\'' +
                ",PromoEndDate='" + superPromoEndDate + '\'' +
                '}';
    }
}
