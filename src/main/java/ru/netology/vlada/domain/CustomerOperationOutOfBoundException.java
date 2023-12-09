package ru.netology.vlada.domain;

public class CustomerOperationOutOfBoundException extends OperationException {

//    public static final String MESSAGE = "Exception while trying to save operation %s for customer %s";
    private int customerId;
    private Operation operation;

    public CustomerOperationOutOfBoundException(int customerId, Operation operation) {
        super();
        this.customerId = customerId;
        this.operation = operation;
    }

    @Override
    public String getMessage() {
        return "Exception while trying to save operation "+ operation +" for customer "+customerId;//MESSAGE.formatted(operationId, customerId);
    }
}