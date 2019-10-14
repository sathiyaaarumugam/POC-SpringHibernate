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

    public void insertCustomer(Customer cust) {
        customerServiceDao.insertCustomer(cust);
    }

    public void insertOrder(OrderTrans orderTrans) {
        customerServiceDao.insertOrder(orderTrans);
    }

    public Customer RetrieveCustById(int custId) {
        return customerServiceDao.RetrieveCustById(custId);
    }

    public List<OrderTrans> RetrieveAllOrderByCustId(int CustId) {
        return customerServiceDao.RetrieveAllOrderByCustId(CustId);
    }

    public String RetrieveOrderStatus(int orderId) {
        return customerServiceDao.RetrieveOrderStatus(orderId);
    }
}
