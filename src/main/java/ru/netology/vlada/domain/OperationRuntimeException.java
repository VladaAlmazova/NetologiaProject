package ru.netology.vlada.domain;

public class OperationRuntimeException extends RuntimeException{
    public OperationRuntimeException(int id)
    {
        super("некоректно указан номер " + id);
    }
}
