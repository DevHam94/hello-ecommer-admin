package com.fastcampus.helloecommeradmin.controller;

import com.fastcampus.helloecommeradmin.domain.entity.Customer;
import com.fastcampus.helloecommeradmin.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final static String CUSTOMER_ATTRIBUTE_KEY = "customers";

    @GetMapping(value = {"/customers", "customers/"})
    public String index(@PageableDefault()Pageable pageable, Model model) {
        List<Customer> customers = customerService.findAllByActiveCustomer(pageable);
        List<CustomerDTO> customerDTOs = customers.streem()
                .map(customer -> CustomerDTO.of(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getPhoneNumber(),
                        customer.getAddress(),
                        customer.getGrade(),
                        customer.getCreatedAt(),
                        customer.getUpdatedAt()
                ))
                .collect(Collectors.toList());
        model.addAttribute(CUSTOMER_ATTRIBUTE_KEY, customerDTOs);
        return "/customers/customers";
    }

    @GetMapping("/customers/customer-detail")
    public String detail(@RequestParam Long customerId, Model model) { return ".customers/customer-detail"; }
}
