package ru.netology.vlada.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.vlada.controller.dto.CustomerDTO;
import ru.netology.vlada.controller.dto.CustomersGetResponse;
import ru.netology.vlada.domain.Customer;
import ru.netology.vlada.service.CustomerService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public CustomersGetResponse getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(customer -> new CustomerDTO(customer.getId(), customer.getName()))
                .collect(Collectors.toList());
        return new CustomersGetResponse(customerDTOS);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") int id){
        Customer customer = customerService.getCustomer(id);
        return new CustomerDTO(customer.getId(), customer.getName());
    }

    @PostMapping
    public void setCustomer(@PathVariable("id") int id, String name){
        customerService.setCustomer(new Customer(id, name));
    }
}