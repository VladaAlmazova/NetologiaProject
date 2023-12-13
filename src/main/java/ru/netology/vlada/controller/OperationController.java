package ru.netology.vlada.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.vlada.controller.dto.OperationDTO;
import ru.netology.vlada.controller.dto.OperationsGetResponse;
import ru.netology.vlada.domain.ContactingCustomerException;
import ru.netology.vlada.domain.CustomerOperationOutOfBoundException;
import ru.netology.vlada.domain.Operation;
import ru.netology.vlada.service.StatementService;

import javax.imageio.ImageReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/operations")
@RequiredArgsConstructor
public class OperationController {

    private final StatementService statementService;

//    @GetMapping
//    public List<OperationsGetResponse> getAllOperations(){    //OperationDTO
//        List<OperationsGetResponse> AllOperations = new ArrayList<OperationsGetResponse>();
//        Set<Integer> customersId = statementService.getStatement().keySet();
//        for(int id_customer: customersId){
//            List<Operation> operations = statementService.getOperations(id_customer);
//            List<OperationDTO> operationDTOS = operations.stream()
//                    .map(operation -> new OperationDTO(operation.getId(), operation.getSum(),
//                            operation.getCurrency(), operation.getMerchant()))
//                    .collect(Collectors.toList());
//            AllOperations.add(new OperationsGetResponse(operationDTOS));
//        }
//
//        return AllOperations;
//    }

    @GetMapping("/{id_customer}")
    public OperationsGetResponse getOperations(@PathVariable("id_customer") int id_customer){    //OperationDTO
        List<Operation> operations = statementService.getOperations(id_customer);
        List<OperationDTO> operationDTOS = operations.stream()
                .map(operation -> new OperationDTO(operation.getId(), operation.getSum(),
                        operation.getCurrency(), operation.getMerchant()))
                .collect(Collectors.toList());
        return new OperationsGetResponse(operationDTOS);
    }

    @GetMapping("/{id_customer}/{id}")
    public OperationDTO getOperation(@PathVariable("id_customer") int id_customer, @PathVariable("id") int id){
        Operation operation = statementService.getOperations(id_customer)
                .get(statementService.getIndexOperation(id_customer, id));
        return new OperationDTO(operation.getId(), operation.getSum(), operation.getCurrency(), operation.getMerchant());
    }

//    @PostMapping
//    public void setOperation(int id_customer, int id, int sum, String currency, String merchant) throws CustomerOperationOutOfBoundException, ContactingCustomerException {
//        statementService.Save_statement(id_customer, new Operation(id, sum, currency, merchant));
//    }

    @PostMapping
    public void setOperation(int id_customer, Operation operation) throws CustomerOperationOutOfBoundException, ContactingCustomerException {
        statementService.Save_statement(id_customer, operation);
    }

    @DeleteMapping
    public void delOperation(int id_customer, int id){
        statementService.delStorage(id_customer, id);
    }
}
