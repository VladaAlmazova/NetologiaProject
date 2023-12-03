package ru.netology.vlada;

import com.sun.jdi.ObjectReference;
import ru.netology.vlada.domain.*;
import ru.netology.vlada.service.StorageService;

import java.nio.file.FileSystemNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static ru.netology.vlada.service.CustomerService.*;
import static ru.netology.vlada.service.StorageService.*;
import static ru.netology.vlada.service.OperationsService.*;
import static ru.netology.vlada.service.StatementService.*;
import static ru.netology.vlada.service.lOService.Clients_operations;


public class Main {
    public static StorageService<Customer> customerStorageService = new StorageService<>();
    public static StorageService<Operation> operationStorageService = new StorageService<>();

    public static void main(String[] args) throws CustomerOperationOutOfBoundException {
        Scanner scanner = new Scanner(System.in);
        inputCustomers(scanner); //ok
        inputOperations(scanner);//ok

        System.out.println(Arrays.toString(customerStorageService.getCustomers()));
        System.out.println(Arrays.toString(operationStorageService.getOperations()));
        System.out.println(Arrays.toString(operationStorageService.getCustomers_operationCount()));//storageService

        Clients_operations(scanner);

        // проверка работы printToConsole
        /*Operation[] newArrOperation = new Operation[10];
        newArrOperation[0] = new LoanOperation();
        newArrOperation[1] = new CashbackOperation();
        newArrOperation[2] = new Operation();
        System.out.println(newArrOperation[0].printToConsole());
        System.out.println(newArrOperation[1].printToConsole());
        System.out.println(newArrOperation[2].printToConsole());*/
    }

}