package ru.netology.vlada;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.vlada.controller.OperationController;
import ru.netology.vlada.controller.dto.OperationDTO;
import ru.netology.vlada.controller.dto.OperationsGetResponse;
import ru.netology.vlada.domain.ContactingCustomerException;
import ru.netology.vlada.domain.CustomerOperationOutOfBoundException;
import ru.netology.vlada.domain.Operation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationControllerTest extends OperationHistoryApiApplicationTest{
    @Autowired
    private OperationController operationController;

    @Test
    public void getOperationsTest(){
        OperationsGetResponse operations_client1 = operationController.getOperations(1);
        OperationsGetResponse operations_client2 = operationController.getOperations(2);

        OperationDTO op_cl1_1 = operations_client1.getOperations().get(0);
        OperationDTO op_cl2_1 = operations_client2.getOperations().get(0);
        OperationDTO op_cl2_2 = operations_client2.getOperations().get(1);

        assertEquals(11, op_cl1_1.getId());
        assertEquals(1005, op_cl1_1.getSum());
        assertEquals(5, op_cl2_1.getId());
        assertEquals(9, op_cl2_2.getId());
    }

    @Test
    public void getOperationTest(){
        OperationDTO op_cl1_1 = operationController.getOperation(1, 11);
        OperationDTO op_cl2_1 = operationController.getOperation(2, 5);
        OperationDTO op_cl2_2 = operationController.getOperation(2, 9);

        assertEquals(11, op_cl1_1.getId());
        assertEquals(1005, op_cl1_1.getSum());
        assertEquals(5, op_cl2_1.getId());
        assertEquals(9, op_cl2_2.getId());
    }
    
    @Test
    public void setOperationTest() throws CustomerOperationOutOfBoundException, ContactingCustomerException {
        operationController.setOperation(1, new Operation(20, 100, "USD", "Zara"));
        
        OperationDTO op_cl1_2 = operationController.getOperation(1, 20);
        assertEquals(20, op_cl1_2.getId());
        assertEquals("Zara", op_cl1_2.getMerchant());
    }

    @Test
    public void delOperationTest() throws CustomerOperationOutOfBoundException, ContactingCustomerException {
        operationController.delOperation(2, 5);

        assertEquals(1, operationController.getOperations(2).getOperations().size());

        operationController.setOperation(2, new Operation(5, 200, "EVR", "Amazon"));
    }
}
