package ru.netology.vlada.service;

import java.util.Arrays;
import java.util.Scanner;

import static ru.netology.vlada.service.OperationsService.getOperations;

//работа с вводом/выводом информации
public class lOService {

    public static void Clients_operations(Scanner scanner){
        System.out.println("Хотите вывести операции клиента? Y/N");
        String ansqer = scanner.next();
        if (!ansqer.equals("N")) {
            System.out.println("Укажите id клиента");
            int id_client = scanner.nextInt();
            System.out.println(Arrays.deepToString(getOperations(id_client)));
        }
    }
}
