package ru.netology.vlada.service;

import ru.netology.vlada.domain.Customer;
import ru.netology.vlada.Main;
import java.util.Scanner;

//import static ru.netology.vlada.service.StorageService.ActiveCustomersId;
import static ru.netology.vlada.Main.customerStorageService;
import static ru.netology.vlada.service.StorageService.*;

public class CustomerService {

    public AvatarsService avatarsService;

    public String getCustomer(){
        return "ClientName" + avatarsService.getAvatar();
    }

    public static void inputCustomers(Scanner scanner) { //было приватным
        int customers_count = 0;
        while (true) {
            System.out.println("Создание клиента");
            System.out.println("Id: ");
            int id = scanner.nextInt();
            if(id < MAX_CUSTOMERS && id>=0)
            {
                if(ActiveCustomersId[id] == 0)
                {
                    ActiveCustomersId[id] = 1;
                }
                else{
                    System.out.println("Клиент с таким номером уже существует, измените номер");
                    continue;
                }
            }
            else{
                System.out.println("Ошибка, что за id такой максимум " +MAX_CUSTOMERS);
                continue;
            }

            System.out.println("Name: ");
            String name = scanner.next();

            Customer newCustomer = new Customer(id, name);
            customerStorageService.setCustomers(customers_count, newCustomer);
//            storageService.setCustomers(customers_count, newCustomer);
//            storageService.getCustomers()[customers_count] = new Customer(id, name);
            customers_count++;
            System.out.println("Ввести ещё одного клиента? Y/N");

            String ansqer = scanner.next();
            if (ansqer.equals("N")) {
                break;
            }

            if (customers_count == MAX_CUSTOMERS) {
                break;
            }
        }
    }
}
