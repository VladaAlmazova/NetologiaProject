package ru.netology.vlada.service;

public class CustomerService {

    public AvatarsService avatarsService;

    public String getCustomer(){
        return "ClientName" + avatarsService.getAvatar();
    }
}
