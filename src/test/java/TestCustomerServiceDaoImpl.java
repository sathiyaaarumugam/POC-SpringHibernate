import com.example.test.dao.CustomerServiceDaoImpl;
import com.example.test.model.Customer;
import com.example.test.model.OrderTrans;
import com.example.test.model.SuperCust;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:spring-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCustomerServiceDaoImpl {

    @Autowired
    CustomerServiceDaoImpl customerServiceDao;
    @Test
    public void testInsertCustomer()
    {
        SuperCust superCust = new SuperCust("Sathiya","Arumugam","Korattur","S","9865091121");
        superCust.setSuperPromoCode("super1");
        superCust.setSuperPromoEndDate("25/10/2019");
        customerServiceDao.insertCustomer(superCust);
        Customer testCust=  customerServiceDao.RetrieveCustById(superCust.getCustId());
        Assert.assertEquals(superCust.getCustFirstName(),testCust.getCustFirstName());

    }
    @Test
    public void testRetrieveCustomerById()
    {
        Customer testCust=  customerServiceDao.RetrieveCustById(1021);
        Assert.assertEquals(testCust.getCustFirstName(),"Sathiya");

    }
    @Test
    public void testInsertOrder()
    {
        OrderTrans orderTrans1 = new OrderTrans("Shipped","Pen Stand",395,"11/10/2019",1021);
        customerServiceDao.insertOrder(orderTrans1);
        String testOrder = customerServiceDao.RetrieveOrderStatus(orderTrans1.getOrderId());
        Assert.assertEquals(testOrder,"Shipped");

    }

    @Test
    public void testRetrieveAllOrders()
    {

        List<OrderTrans> orderList= customerServiceDao.RetrieveAllOrderByCustId(1021);

        Assert.assertEquals(orderList.get(0).getCustId(),"1021");

    }

}
