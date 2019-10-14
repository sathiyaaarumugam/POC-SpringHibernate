package com.example.test.service;

import com.example.test.model.Customer;
import com.example.test.model.OrderTrans;

import java.util.List;

public interface CustomerService {

    public void insertCustomer(Customer cust);
    public void insertOrder(OrderTrans orderTrans);
    public  Customer RetrieveCustById(int custId);
    public List<OrderTrans> RetrieveAllOrderByCustId(int CustId);
    public String RetrieveOrderStatus(int orderId);
}
