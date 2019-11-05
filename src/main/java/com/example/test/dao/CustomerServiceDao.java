package com.example.test.dao;

import com.example.test.model.Customer;
import com.example.test.model.OrderTrans;

import java.util.List;

public interface CustomerServiceDao {

    public void insertCustomer(Customer cust) throws Exception;
    public void insertOrder(OrderTrans orderTrans) throws Exception;
    public  Customer RetrieveCustById(int custId) throws Exception;
    public List<OrderTrans> RetrieveAllOrderByCustId(int CustId) throws Exception;
    public String RetrieveOrderStatus(int orderId) throws Exception;
}
