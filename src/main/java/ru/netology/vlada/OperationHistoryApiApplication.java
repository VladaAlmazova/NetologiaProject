package ru.netology.vlada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import ru.netology.vlada.configuration.AppConfiguration;
import ru.netology.vlada.domain.*;
import ru.netology.vlada.service.AsyncInputOperationService;
//import ru.netology.vlada.service.OperationService;
//import ru.netology.vlada.service.StorageService;

import java.util.List;
import java.util.Map;
//import static ru.netology.vlada.service.OperationService.*;
//import static ru.netology.vlada.service.IOService.Clients_operations;

//TODO
@SpringBootApplication
public class OperationHistoryApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(OperationHistoryApiApplication.class, args);
    }
}

//было
//@SpringBootApplication
//public class OperationHistoryApiApplication {

//    public static AsyncInputOperationService asyncInputOperationService;
//
//    public static final int OPERATIONS_PER_CUSTOMER = 100;
//    public static final int MAX_CUSTOMERS = 10;

//    public static void main(String[] args)
//            throws CustomerOperationOutOfBoundException, CustomerCreationException, ContactingCustomerException {
//

//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
//        AsyncInputOperationService asyncInputOperationService = context.getBean(AsyncInputOperationService.class);
//        StatementService statementService = context.getBean(StatementService.class);
//        CustomerService customerService = context.getBean(CustomerService.class);
//        asyncInputOperationService.startProcessing();

//        Customer[] customers = new Customer[]{
//                new Customer(1, "Ann"),
//                new Customer(2, "Ben"),
//                new Customer(3, "Din")
//        };

//        for(Customer customer: customers){
//            customerService.setCustomers(customer);
//        }
//
//        Operation[] operations = new Operation[]{
//                new Operation(11, 1005, "USD", "Nike"),
//                new Operation(20, 100, "USD", "Zara"),
//                new Operation(5, 200, "EVR", "Amazon"),
//                new Operation(9, 450, "RUR", "Ozon"),
//                new Operation(50, 856, "RUR", "Ford"),
//                new Operation(41, 50, "EVR", "Samsung")
//        };
//
//        for(Operation operation : operations){
//            asyncInputOperationService.addOperation(operation);
//        }
//
//        statementService.Save_many_statement(1, new Operation[]{operations[0], operations[1], operations[2]});
//        statementService.Save_many_statement(2, new Operation[]{operations[3], operations[4]});
//        statementService.Save_many_statement(3, new Operation[]{operations[5]});
//
//
//        System.out.println(statementService);
//        for(Map.Entry<Integer, List<Operation>> entry: statementService.getStatement().entrySet()) {
//            // get key
//            Integer key = entry.getKey();
//            // get value
//            List<Operation> value = entry.getValue();
//            System.out.println(key + " = " + value.toString());
//        }
//    }
//}