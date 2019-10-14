package com.example.test.model;

import javax.persistence.*;

@Entity
@Table(name="privilege_cust_tbl")
@PrimaryKeyJoinColumn(name="cust_id")
public class PrivilegeCust extends Customer {



    @Column (name="privilege_promo_code")
    private String privilegePromoCode;

    @Column (name="privilege_promo_end_date")
    private String privilegePromoEndDate;

    public PrivilegeCust(String custFirstName, String custLastName, String custAddress, String custType, String custMobile) {
        super(custFirstName, custLastName, custAddress, custType, custMobile);
    }

    public PrivilegeCust(){

    }

    public String getPrivilegePromoCode() {
        return privilegePromoCode;
    }

    public void setPrivilegePromoCode(String privilegePromoCode) {
        this.privilegePromoCode = privilegePromoCode;
    }

    public String getPrivilegePromoEndDate() {
        return privilegePromoEndDate;
    }

    public void setPrivilegePromoEndDate(String privilegePromoEndDate) {
        this.privilegePromoEndDate = privilegePromoEndDate;
    }

    @Override
    public String toString() {
        return "Privilege Customer{" +
                "customer Id=" + getCustId() +
                ", First Name='" + getCustFirstName() + '\'' +
                ", Last Name='" + getCustLastName() + '\'' +
                ", Address='" + getCustAddress() + '\'' +
                ", Type='" + getCustType() + '\'' +
                ", Mobile='" + getCustMobile() + '\'' +
                " PromoCode='" + privilegePromoCode + '\'' +
                ",PromoEndDate='" + privilegePromoEndDate + '\'' +
                '}';
    }
}
