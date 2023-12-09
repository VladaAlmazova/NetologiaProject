package ru.netology.vlada.domain;

public class ContactingCustomerException extends Exception{
    private int customerId;
    public ContactingCustomerException(int customerId) {
        super();
        this.customerId = customerId;
    }

    @Override
    public String getMessage() {
        return "Exception while trying to contacting the customer with ID: "+ customerId;
    }
}
