import com.example.test.model.Customer;
import com.example.test.model.OrderTrans;
import com.example.test.model.SuperCust;
import com.example.test.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:spring-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCustomerServiceImpl {

    @Autowired
    CustomerService customerService;

    @Test
    public void testInsertCustomer() throws Exception {
        SuperCust superCust = new SuperCust("John","Kim","London","S","9873463721");
        superCust.setSuperPromoCode("super1");
        superCust.setSuperPromoEndDate("25/10/2019");
        customerService.insertCustomer(superCust);
        Customer testCust=  customerService.RetrieveCustById(superCust.getCustId());
        Assert.assertEquals(superCust.getCustFirstName(),testCust.getCustFirstName());

    }
    @Test
    public void testRetrieveCustomerById() throws Exception {
        Customer testCust=  customerService.RetrieveCustById(1002);
        //System.out.println("testCust.getCustFirstName()"+testCust.getCustFirstName());
        Assert.assertEquals(testCust.getCustFirstName(),"John");

    }
    @Test
    public void testInsertOrder() throws Exception {
        OrderTrans orderTrans1 = new OrderTrans("Shipped","Paper Roll",595,"11/10/2019",1002);
        customerService.insertOrder(orderTrans1);
        String testOrder = customerService.RetrieveOrderStatus(orderTrans1.getOrderId());
        Assert.assertEquals(testOrder,"Shipped");

    }

    @Test
    public void testRetrieveAllOrders() throws Exception {

        List<OrderTrans> orderList= customerService.RetrieveAllOrderByCustId(1002);

        Assert.assertEquals(orderList.get(0).getCustId(),1002);

    }
    @Test
    public void testRetrieveOrderStatusbyId() throws Exception {

      String staus= customerService.RetrieveOrderStatus(2002);

        Assert.assertEquals("Shipped",staus);

    }
}
