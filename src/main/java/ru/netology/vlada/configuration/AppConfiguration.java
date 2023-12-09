package ru.netology.vlada.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.vlada.domain.Customer;
import ru.netology.vlada.service.*;
//import ru.netology.vlada.service.CustomerService;
//import ru.netology.vlada.service.IOService;
//import ru.netology.vlada.service.StatementService;
//import ru.netology.vlada.service.StorageService;

@Configuration
public class AppConfiguration {
    @Bean
    public StatementService statementService() {
        return new StatementService();
    }

    @Bean
    public CustomerService customerService(){ return new CustomerService();}

    @Bean
    public AsyncInputOperationService asyncInputOperationService(StatementService statementService){
        return new AsyncInputOperationService(statementService);
    }

//    @Bean
//    public CustomerService customerService(StorageService<Customer> customerStorageService, IOService ioService) {
//        return new CustomerService(customerStorageService, ioService); //перенести создание клиентов в CustomerService
//    }
}
