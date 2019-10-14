package com.example.test.dao;

import com.example.test.model.Customer;
import com.example.test.model.OrderTrans;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerServiceDaoImpl implements CustomerServiceDao {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertCustomer(Customer cust) {
        Session session=this.sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        session.save(cust);
        tx.commit();

    }

    public void insertOrder(OrderTrans orderTrans) {
        Session session=this.sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        session.save(orderTrans);
        tx.commit();
    }

    public Customer RetrieveCustById(int custId) {
        Session session=this.sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        String queryTxt = "FROM Customer WHERE custId= :custId";
        Query query= session.createQuery(queryTxt);
        query.setParameter("custId",custId);
        Customer cus= (Customer) query.list().get(0);
        tx.commit();
        return cus;
    }

    public List<OrderTrans> RetrieveAllOrderByCustId(int CustId) {
        Session session=this.sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        String queryTxt = "FROM OrderTrans a WHERE a.custId= :custId";
        Query query= session.createQuery(queryTxt);
        query.setParameter("custId",CustId);
        List<OrderTrans> list = query.list();
        tx.commit();
        return list;
    }

    public String RetrieveOrderStatus(int orderId) {
        Session session=this.sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        String queryTxt = "select orderStatus FROM OrderTrans a WHERE a.orderId= :orderId";
        Query query= session.createQuery(queryTxt);
        query.setParameter("orderId",orderId);
        String status=(String)query.list().get(0);
        tx.commit();
        return status;
    }
}
