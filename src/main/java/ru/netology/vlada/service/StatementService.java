package ru.netology.vlada.service;

//import jdk.internal.access.JavaIOFileDescriptorAccess;
import ru.netology.vlada.domain.ContactingCustomerException;
import ru.netology.vlada.domain.Customer;
import ru.netology.vlada.domain.CustomerOperationOutOfBoundException;
import ru.netology.vlada.domain.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static ru.netology.vlada.Main.operationStorageService;
import static ru.netology.vlada.Main.OPERATIONS_PER_CUSTOMER;
//import static ru.netology.vlada.Main.customerService;
//import static ru.netology.vlada.service.StorageService.*;

//работа с выпиской
public class StatementService {
    private final Map<Integer, List<Operation>> storage = new HashMap<>();

    public void Save_many_statement(int customerId, Operation[] operations) throws CustomerOperationOutOfBoundException, ContactingCustomerException {
//        storage.putIfAbsent(customerId, new ArrayList<>());
        for(Operation operation : operations) {
            Save_statement(customerId, operation);
        }
    }

    public void Save_statement(int customerId, Operation operation) throws CustomerOperationOutOfBoundException, ContactingCustomerException {
//        if(!storage.containsKey(customerId))     //важно ли существование клиента?
//            throw new ContactingCustomerException(customerId);
        storage.putIfAbsent(customerId, new ArrayList<Operation>());
        if (operation != null) {
            if (storage.get(customerId).size() < OPERATIONS_PER_CUSTOMER) {
                storage.get(customerId).add(operation);
            } else {
                throw new CustomerOperationOutOfBoundException(customerId, operation);
            }
        }
    }

    public Map<Integer, List<Operation>> getStatement() {
        return storage;
    }

    public List<Operation> getOperations(int clientId){ //del?
        return storage.get(clientId);
    }

}
