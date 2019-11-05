package com.example.test.dao;

import com.example.test.model.Customer;
import com.example.test.model.OrderTrans;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CustomerServiceDaoImpl implements CustomerServiceDao {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertCustomer(Customer cust){
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.save(cust);
            tx.commit();
        } catch (HibernateException e1) {
          throw e1;
        }

    }

    public void insertOrder(OrderTrans orderTrans){
        try {
        Session session=this.sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        session.save(orderTrans);
        tx.commit();
        } catch (HibernateException e1) {
            throw e1;
        }
    }

    public Customer RetrieveCustById(int custId) {
        Customer cus=null;
        try{
        Session session=this.sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("custId",custId));
        List result =criteria.list();
        if(result!=null && !result.isEmpty()) {
            cus = (Customer) result.get(0);
        }
        } catch (HibernateException e1) {
            throw e1;
        }
        return cus;
    }

    public List<OrderTrans> RetrieveAllOrderByCustId(int CustId) {
        List<OrderTrans> result =null;
        try{
        Session session=this.sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        Criteria criteria = session.createCriteria(OrderTrans.class);
        criteria.add(Restrictions.eq("custId",CustId));
        result =criteria.list();
        } catch (HibernateException e1) {
            throw e1;
        }
        return result;
    }

    public String RetrieveOrderStatus(int orderId) {
        String status=null;
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Transaction tx=session.beginTransaction();
            Criteria criteria= session.createCriteria(OrderTrans.class);
            criteria.add(Restrictions.eq("orderId",orderId));
            List<OrderTrans> result=criteria.list();
            if(result!=null && !result.isEmpty()){
                OrderTrans orderTrans =result.get(0);
                if(orderTrans!=null) {
                    status = orderTrans.getOrderStatus();
                }
            }
        }catch (HibernateException e1){
            throw e1;
        }
        return status;
    }
}
