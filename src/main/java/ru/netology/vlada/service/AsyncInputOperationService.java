package ru.netology.vlada.service;

import java.util.LinkedList;
import java.util.Queue;

import ru.netology.vlada.domain.Operation;

//import static jdk.internal.vm.PostVMInitHook.run;

public class AsyncInputOperationService {
    private Queue<Operation> operations = new LinkedList<>();
    private StatementService statementService;

    public AsyncInputOperationService(StatementService statementService){
        this.statementService = statementService;
    }


    public boolean addOperation(Operation operation) {
        System.out.println("Операция добавлена в процесс " + operation);
        return operations.offer(operation);
    }

    public void startProcessing(){
        Thread t = new Thread() {
            @Override
            public void run() {
                processQueue();
            }
        };
        t.start();
    }

    private void processQueue() {
        while (true) {
            Operation operation = operations.poll();
            if (operation == null) {
                try {
                    System.out.println("Waiting for next operation in queue");
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //TODO подождать следующую операцию
            }
            else {
                System.out.println("Processing operation:" + operation);
                processOperation(operation);
            }
        }
    }

    private void processOperation(Operation operation){

    }



//    private Queue<Operation> queueOperationsToSave = new LinkedList<>();
//    private final StatementService statementService = new StatementService();
////    private final OperationService operationService = new OperationService();
//
//    public AsyncInputOperationService(OperationService operationService) {
//    }
//
//    //метод для добавление операции для последующей обработки
//    public boolean offerOperation(Operation operation) {
//        return queueOperationsToSave.offer(operation);
//    }
//
//    //метод, в котором будет логика обработки очереди
//    private void processQueue() {
//        while (true) {
//            Operation operation = queueOperationsToSave.poll();
//            if (operation == null) {
//                try {
//                    System.out.println("Waiting for next operation in queue");
//                    Thread.sleep(1_000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            else {
//                System.out.println("Processing operation:" + operation);
//                operationService.addOperation(operation);
//            }
//        }
//    }
//
//    public void startAsyncOperationProcessing() {
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                processQueue();
//            }
//        };
//        t.start();
//    }

}
