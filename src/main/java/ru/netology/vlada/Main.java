package ru.netology.vlada;

import com.sun.jdi.ObjectReference;
import ru.netology.vlada.domain.*;

import java.nio.file.FileSystemNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static final int MAX_OPERATIONS = 1000;
    public static final int MAX_CUSTOMERS = 100;

    private static final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private static final Operation[] operations = new Operation[MAX_OPERATIONS];
    public static int[] ActiveCustomersId = new int[Main.MAX_CUSTOMERS];

    //private static final int[][] statement = new int[MAX_CUSTOMERS][MAX_OPERATIONS/MAX_CUSTOMERS];
    private static final Operation[][] statement = new Operation[MAX_CUSTOMERS][MAX_OPERATIONS/MAX_CUSTOMERS];
    private static final int[] customers_operationCount = new int[MAX_CUSTOMERS];


    public static void main(String[] args) throws CustomerOperationOutOfBoundException {
        Scanner scanner = new Scanner(System.in);
        inputCustomers(scanner);
        System.out.println(Arrays.toString(customers));
        inputOperations(scanner);
        System.out.println(Arrays.toString(operations));
//        Operation.print(operations[0]);
        System.out.println(Arrays.deepToString(statement));
        System.out.println(Arrays.toString(customers_operationCount));

        System.out.println("Хотите вывести операции клиента? Y/N");
        String ansqer = scanner.next();
        if (!ansqer.equals("N")) {
            System.out.println("Укажите id клиента");
            int id_client = scanner.nextInt();
//            System.out.println(Arrays.deepToString(getOperations(id_client)));
            System.out.println(Arrays.deepToString(getOperations(id_client)));
        }

        // проверка работы printToConsole
        /*Operation[] newArrOperation = new Operation[10];
        newArrOperation[0] = new LoanOperation();
        newArrOperation[1] = new CashbackOperation();
        newArrOperation[2] = new Operation();
        System.out.println(newArrOperation[0].printToConsole());
        System.out.println(newArrOperation[1].printToConsole());
        System.out.println(newArrOperation[2].printToConsole());*/
    }

    private static void inputCustomers(Scanner scanner) {
        int customers_count = 0;
        while (true) {
            System.out.println("Создание клиента");
            System.out.println("Id: ");
            int id = scanner.nextInt();

            if(ActiveCustomersId[id] == 0)
            {
                ActiveCustomersId[id] = 1;
            }
            else{
                System.out.println("Клиент с таким номером уже существует, измените номер");
                continue;
            }

            System.out.println("Name: ");
            String name = scanner.next();
            customers[customers_count] = new Customer(id, name);
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

    private static void inputOperations(Scanner scanner) throws CustomerOperationOutOfBoundException {
        int operations_id = 0;
        while(true) {
            System.out.println("Создание транзакции");
            System.out.println("Id: ");
            int id = scanner.nextInt();
            System.out.println("Sum: ");
            int sum = scanner.nextInt();
            System.out.println("currency: ");
            String currency = scanner.next();
            System.out.println("merchant: ");
            String merchant = scanner.next();

            System.out.println("CustomerId: ");
            int customerId = scanner.nextInt();
            if (customerId >= MAX_CUSTOMERS)
            {
                System.out.println("id > max_id мы не можем добавить операцию этому клиенту");
            }
            if(ActiveCustomersId[customerId] == 0)
            {
                System.out.println("клиента с таким id не существует, вы хотите его создать? Y/N");
                String ansqer = scanner.next();
                if (ansqer.equals("N")) {
                    System.out.println("создание транзакции прервано, создайте запрос заново");
                    continue;
                }
                else {
                    inputCustomers(scanner);
                }
            }
//            statement[customerId][customers_operationCount[customerId]] = id;


            operations[operations_id] = new Operation(id, sum, currency, merchant);

            // statement[customerId][customers_operationCount[customerId]] = operations[operations_id];
            Save_statement(customerId, operations_id);

            customers_operationCount[customerId]++;
            operations_id++;

            System.out.println("Ввести ещё одну операцию? Y/N");

            String ansqer = scanner.next();
            if (ansqer.equals("N")) {
                break;
            }

            if (operations_id == MAX_OPERATIONS) {
                break;
            }
        }
    }

    private static void Save_statement(int customerId, int operations_id) throws CustomerOperationOutOfBoundException {
        if(customerId >= 0 && customerId < MAX_CUSTOMERS &&
                customers_operationCount[customerId] < (MAX_OPERATIONS/MAX_CUSTOMERS)){
            statement[customerId][customers_operationCount[customerId]] = operations[operations_id];
        }
        else{
            throw new CustomerOperationOutOfBoundException(customerId, operations_id);
        }
    }

    public static Operation[] getOperations(int clientId){
        return statement[clientId];
    }
}
/*Operation[] operations = new Operation[10];
        Customer[] customers = new Customer[10];
        int[][] statement = new int[10][10];
        statement[1][0] = 2;
        statement[1][1] = 20;
        statement[1][2] = 38;
        statement[1][3] = 125;
    }
    public static Operation[] getOperations(int clientId, int[][] statement){
        Operation[] operations = new Operation[statement[clientId].length];
        for(int i = 0; i < operations.length; i++)
        {
            operations[i] = new Operation();
        }
        return operations;
    }*/