package com.MarketBudget.Project.service;

import com.MarketBudget.Project.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomer();
    void delete(Long id);
    CustomerDTO update(Long id, CustomerDTO customerDTO);
}
