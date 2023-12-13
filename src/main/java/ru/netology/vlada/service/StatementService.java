package ru.netology.vlada.service;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.netology.vlada.domain.ContactingCustomerException;
import ru.netology.vlada.domain.CustomerOperationOutOfBoundException;
import ru.netology.vlada.domain.Operation;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//работа с выпиской
@Component
@Data
public class StatementService {
    private final int OPERATIONS_PER_CUSTOMER = 100;
    private final Map<Integer, List<Operation>> storage = new HashMap<>();

    public void Save_many_statement(int customerId, Operation[] operations)
            throws CustomerOperationOutOfBoundException, ContactingCustomerException {
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

    public void delStorage(int idCustomer, int id) {
        storage.get(idCustomer).remove(getIndexOperation(idCustomer, id));
    }

    public int getIndexOperation(int customerId, int operationId) {
        List<Operation> listOperations = storage.get(customerId);
        int ind = 0;
        for(Operation operation : listOperations){
            if(operation.getId() == operationId)
                return ind;
            ind++;
        }
        return -1; //TODO добавить ошибку
    }

    @PostConstruct
    public void initStorage() throws CustomerOperationOutOfBoundException, ContactingCustomerException {
        Save_statement(1, new Operation(11, 1005, "USD", "Nike"));
//        Save_statement(1, new Operation(20, 100, "USD", "Zara"));
        Save_statement(2, new Operation(5, 200, "EVR", "Amazon"));
        Save_statement(2, new Operation(9, 450, "RUR", "Ozon"));
//        Save_statement(2, new Operation(50, 856, "RUR", "Ford"));
//        Save_statement(2, new Operation(41, 50, "EVR", "Samsung"));
    }


//    public List<Operation> getAllOperations(){ //del?
//
//        return new ArrayList<Operation>(storage.values());
//    }
}
