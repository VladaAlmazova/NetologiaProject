//package ru.netology.vlada.service;
//
////                                      import lombok.Data;
//import lombok.Data;
//import ru.netology.vlada.Main;
//import ru.netology.vlada.domain.Customer;
//import ru.netology.vlada.domain.Operation;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////работа с хранением данных
////@Data
//public class StorageService<T> {
//
//    private final List<T> storage = new ArrayList<>();
//
//
//    public static final int OPERATIONS_PER_CUSTOMER = 100;
//    public static final int MAX_CUSTOMERS = 10;
//    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
//    private final Operation[] operations = new Operation[MAX_CUSTOMERS * OPERATIONS_PER_CUSTOMER];
////    private static final int[][] statement = new int[MAX_CUSTOMERS][OPERATIONS_PER_CUSTOMER];
////    private static final Operation[][] statement = new Operation[MAX_CUSTOMERS][OPERATIONS_PER_CUSTOMER];
////    public static int[] ActiveCustomersId = new int[MAX_CUSTOMERS];
//    private static final int[] customers_operationCount = new int[MAX_CUSTOMERS];
//
////    public Customer[] getCustomers() {
////        return customers;
////    }
////    public void setCustomers(int id, Customer customer){
////        customers[id] = customer;
////    }
//
////    public Operation[] getOperations() {
////        return operations;
////    }
////    public void setOperations(int operations_id, Operation operation){
////        operations[operations_id] = operation;
////    }
////    public int[] getCustomers_operationCount(){ return customers_operationCount;}
//
////    public void setCustomers_operationCount(int customerId)
////    {
////        customers_operationCount[customerId]++;
////    }
//
////    public int[][] getStatement() {
////        return statement;
////    }
//
////    public void setStatement(int customerId, int nextOperation, Operation operation){
////        statement[customerId][nextOperation] = operation;
////    }
//
//    public T getElement(int position) {
//        return storage.get(position);
//    }
//
//    public void setElement(T element) {
//        storage.add(element);
//    }
//}
