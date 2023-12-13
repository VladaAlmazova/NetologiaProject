package ru.netology.vlada;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.vlada.controller.CustomerController;
import ru.netology.vlada.controller.dto.CustomerDTO;
import ru.netology.vlada.controller.dto.CustomersGetResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

//public class CustomerControllerTest {
//}
class CustomerControllerTest extends OperationHistoryApiApplicationTest {
    @Autowired
    private CustomerController customerController;

    @Test
    public void getClientsTest(){
        CustomersGetResponse customers = customerController.getCustomers();
        CustomerDTO customer1 = customers.getCustomers().get(0);
        CustomerDTO customer2 = customers.getCustomers().get(1);

        assertEquals(1, customer1.getId());
        assertEquals("Spring", customer1.getName());
        assertEquals(2, customer2.getId());
        assertEquals("Boot", customer2.getName());
    }

    @Test
    public void getClientTest(){
        CustomerDTO customer1 = customerController.getCustomer(1);
        CustomerDTO customer2 = customerController.getCustomer(2);

        assertEquals(1, customer1.getId());
        assertEquals("Spring", customer1.getName());
        assertEquals(2, customer2.getId());
        assertEquals("Boot", customer2.getName());
    }

    @Test
    public void setClientTest(){
        customerController.setCustomer(3, "Alias");

        CustomerDTO customer3 = customerController.getCustomer(3);

        assertEquals(3, customer3.getId());
        assertEquals("Alias", customer3.getName());
    }
}