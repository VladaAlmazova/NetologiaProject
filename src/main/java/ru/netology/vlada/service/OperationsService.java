package ru.netology.vlada.service;

import ru.netology.vlada.domain.CustomerOperationOutOfBoundException;
import ru.netology.vlada.domain.Operation;

import static ru.netology.vlada.Main.operationStorageService;
import static ru.netology.vlada.service.CustomerService.inputCustomers;
import static ru.netology.vlada.service.StatementService.Save_statement;
import static ru.netology.vlada.service.StorageService.*;
import ru.netology.vlada.Main.*;

import java.util.Scanner;

public class OperationsService {

    //было приватным
    public static void inputOperations(Scanner scanner) throws CustomerOperationOutOfBoundException {
        int operations_id = 0;
        while(true) {
            System.out.println("Создание транзакции");
            System.out.println("Id: ");
            int id = scanner.nextInt();
            System.out.println("Sum: ");
            int sum = scanner.nextInt();
            System.out.println("currency: ");
            String currency = scanner.next();
            System.out.println("merchant: ");
            String merchant = scanner.next();

            System.out.println("CustomerId: ");
            int customerId = scanner.nextInt();
            if (customerId >= MAX_CUSTOMERS)
            {
                System.out.println("id > max_id мы не можем добавить операцию этому клиенту");
                continue;
            }

            if(ActiveCustomersId[customerId] == 0)
            {
                System.out.println("клиента с таким id не существует, вы хотите его создать? Y/N");
                String ansqer = scanner.next();
                if (ansqer.equals("N")) {
                    System.out.println("создание транзакции прервано, создайте запрос заново");
                    continue;
                }
                else {
                    inputCustomers(scanner);
                }
            }
//            storageService.getOperations()[operations_id] = new Operation(id, sum, currency, merchant);
            operationStorageService.setOperations(operations_id, new Operation(id, sum, currency, merchant));
            // statement[customerId][customers_operationCount[customerId]] = operations[operations_id];
            Save_statement(customerId, operations_id);
            operationStorageService.setCustomers_operationCount(customerId);//storageService
            operations_id++;

            System.out.println("Ввести ещё одну операцию? Y/N");

            String ansqer = scanner.next();
            if (ansqer.equals("N")) {
                break;
            }

            if (operations_id == MAX_CUSTOMERS * OPERATIONS_PER_CUSTOMER) {
                break;
            }
        }
    }
//storageService
    public static Operation[] getOperations(int clientId){
//        return operationStorageService.getStatement()[clientId];
        return StatementService.getStatement()[clientId];
    }
}
