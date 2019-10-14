package com.example.test.main;

import com.example.test.model.Customer;
import com.example.test.model.OrderTrans;
import com.example.test.model.PrivilegeCust;
import com.example.test.model.SuperCust;
import com.example.test.service.CustomerService;
import com.example.test.service.CustomerServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTestMain {
    public static void main(String args[]){
        System.out.println("test main");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CustomerService service = (CustomerService) context.getBean("customerService", CustomerServiceImpl.class);
        //insert Super CustomerType
        SuperCust superCust = new SuperCust("Sathiya","Arumugam","Korattur","S","9865091121");
        superCust.setSuperPromoCode("super1");
        superCust.setSuperPromoEndDate("25/10/2019");
        service.insertCustomer(superCust);
        int custId= superCust.getCustId();
        OrderTrans orderTrans = new OrderTrans("Ordered","Book",125,"11/10/2019",custId);
        service.insertOrder(orderTrans);
        SuperCust superCust1 = new SuperCust("Sathiya","Arul","Korattur","S","9865091121");
        superCust1.setSuperPromoCode("super2");
        superCust1.setSuperPromoEndDate("28/10/2019");
        service.insertCustomer(superCust1);
        int custId1= superCust1.getCustId();
        OrderTrans orderTrans1 = new OrderTrans("Shipped","Pen Stand",395,"11/10/2019",custId1);
        service.insertOrder(orderTrans1);
        PrivilegeCust pCust = new PrivilegeCust("Arul","R","Korattur","P","9865091191");
        pCust.setPrivilegePromoCode("privi1");
        pCust.setPrivilegePromoEndDate("26/10/2019");
        service.insertCustomer(pCust);
        int custId2= pCust.getCustId();
        OrderTrans orderTrans2 = new OrderTrans("Delivered","Flower vase",564,"08/10/2019",custId2);
        service.insertOrder(orderTrans2);

        List<OrderTrans> c=  service.RetrieveAllOrderByCustId(custId);
        System.out.println("list of orders"+c);
        Customer c1 =service.RetrieveCustById(custId);
        System.out.println("Customer--->"+c1);
        String status= service.RetrieveOrderStatus(orderTrans.getOrderId());
        System.out.println("order status--->"+status);


    }
}

