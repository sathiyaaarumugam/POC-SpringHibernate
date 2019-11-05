package com.example.test.service;

import com.example.test.dao.CustomerServiceDao;
import com.example.test.model.Customer;
import com.example.test.model.OrderTrans;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerServiceDao customerServiceDao;

    public void setCustomerServiceDao(CustomerServiceDao customerServiceDao) {
        this.customerServiceDao = customerServiceDao;
    }

    public void insertCustomer(Customer cust) throws Exception{
        customerServiceDao.insertCustomer(cust);
    }

    public void insertOrder(OrderTrans orderTrans) throws Exception {
        customerServiceDao.insertOrder(orderTrans);
    }

    public Customer RetrieveCustById(int custId) throws Exception {
        return customerServiceDao.RetrieveCustById(custId);
    }

    public List<OrderTrans> RetrieveAllOrderByCustId(int CustId) throws Exception {
        return customerServiceDao.RetrieveAllOrderByCustId(CustId);
    }

    public String RetrieveOrderStatus(int orderId) throws Exception {
        return customerServiceDao.RetrieveOrderStatus(orderId);
    }
}
