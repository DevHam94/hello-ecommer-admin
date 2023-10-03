package com.fastcampus.helloecommeradmin.service;

import com.fastcampus.helloecommeradmin.domain.entity.Customer;
import com.fastcampus.helloecommeradmin.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> findAll() { return customerRepository.findAll(); }

    public List<Customer> findAllByActiveCustomer(Pageable pageable) {
        return customerRepository.findByIsDeletedIsFalse(pageable);
    }
}
