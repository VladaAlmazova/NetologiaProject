package ru.netology.vlada.service;

import ru.netology.vlada.domain.Customer;
import ru.netology.vlada.Main;
import ru.netology.vlada.domain.CustomerCreationException;
import ru.netology.vlada.domain.CustomerOperationOutOfBoundException;

import java.util.ArrayList;
import java.util.Scanner;

//import static ru.netology.vlada.service.StorageService.ActiveCustomersId;
//import static ru.netology.vlada.Main.customerStorageService;
import static ru.netology.vlada.Main.MAX_CUSTOMERS;
//import static ru.netology.vlada.Main.statementService;
//import static ru.netology.vlada.service.StorageService.*;

public class CustomerService {

    private final ArrayList<Customer> customers = new ArrayList<>();//[MAX_CUSTOMERS];

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(Customer customer) throws CustomerCreationException {
        if(customer.getId() < MAX_CUSTOMERS && customer.getId()>=0
                && !customers.contains(customer)){
            customers.add(customer);
        }
        else throw new CustomerCreationException(customer.getId());
    }

//    public static void inputCustomers(Scanner scanner) throws CustomerOperationOutOfBoundException { //было приватным
//        int customers_count = 0;
//        while (true) {
//            System.out.println("Создание клиента");
//            System.out.println("Id: ");
//            int id = scanner.nextInt();
//            if(id < MAX_CUSTOMERS && id>=0)
//            {
//                if(statementService.getStatement().containsKey(id)){
//                    System.out.println("Клиент с таким номером уже существует, измените номер");
//                    continue;
//                }
//                statementService.Save_statement(id, null);
//            }
//            else{
//                System.out.println("Ошибка, что за id такой максимум " +MAX_CUSTOMERS);
//                continue;
//            }
//
//            System.out.println("Name: ");
//            String name = scanner.next();
//
//            Customer newCustomer = new Customer(id, name);
//            customerStorageService.setCustomers(customers_count, newCustomer);
//
//            customers_count++;
//            System.out.println("Ввести ещё одного клиента? Y/N");
//
//            String ansqer = scanner.next();
//            if (ansqer.equals("N")) {
//                break;
//            }
//
//            if (customers_count == MAX_CUSTOMERS) {
//                break;
//            }
//        }
//    }
}
