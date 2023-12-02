package ru.netology.vlada.service;

public class OperationsService {

    public AccountService accountService;
    public CustomerService customerService;

    public void print()
    {
        System.out.println("Client: " + customerService.getCustomer());
        System.out.println("Account: " + accountService.getAccount());
    }
}
