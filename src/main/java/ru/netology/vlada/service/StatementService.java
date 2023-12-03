package ru.netology.vlada.service;

import ru.netology.vlada.domain.CustomerOperationOutOfBoundException;
import ru.netology.vlada.domain.Operation;

import static ru.netology.vlada.Main.operationStorageService;
import static ru.netology.vlada.service.StorageService.*;

//работа с выпиской
public class StatementService {
    //было приватным

    private static final Operation[][] statement = new Operation[MAX_CUSTOMERS][OPERATIONS_PER_CUSTOMER];
    public static void Save_statement(int customerId, int operations_id) throws CustomerOperationOutOfBoundException {
        if(customerId >= 0 && customerId < MAX_CUSTOMERS &&
                operationStorageService.getCustomers_operationCount()[customerId] < (OPERATIONS_PER_CUSTOMER)){
            statement[customerId][operationStorageService.getCustomers_operationCount()[customerId]]= operationStorageService.getOperations()[operations_id];
        }
        else{
            throw new CustomerOperationOutOfBoundException(customerId, operations_id);
        }
    }

    public static Operation[][] getStatement() { //было не static
        return statement;
    }

    public static void setStatement(int customerId, int nextOperation, Operation operation){
        statement[customerId][nextOperation] = operation;
    }
}
