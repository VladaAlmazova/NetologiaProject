package ru.netology.vlada.domain;

public class CustomerCreationException extends Exception {
    private int customerId;
    public CustomerCreationException(int customerId) {
        super();
        this.customerId = customerId;
//        this.operation = operation;
    }

    @Override
    public String getMessage() {
        return "Exception while trying to create customer with ID: "+ customerId;//MESSAGE.formatted(operationId, customerId);
    }
}