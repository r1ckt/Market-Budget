package com.MarketBudget.Project.service.impl;

import com.MarketBudget.Project.dto.CustomerDTO;
import com.MarketBudget.Project.entity.user.Customer;
import com.MarketBudget.Project.exception.ParamNotFoundException;
import com.MarketBudget.Project.mapper.CustomerMapper;
import com.MarketBudget.Project.repository.CustomerRepository;
import com.MarketBudget.Project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerMapper customerMapper;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {

        Customer entity = customerMapper.customerDTO2Entity(customerDTO);
        Customer  entitySaved = customerRepository.save(entity);

        return customerMapper.customerEntity2DTO(entitySaved);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {

        List<Customer> entities = customerRepository.findAll();

        return customerMapper.customerEntityList2DTOList(entities);
    }

    @Override
    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO genreDTO){

        Optional<Customer> entity = customerRepository.findById(id);

        if (entity.isEmpty()) {
            throw new ParamNotFoundException("Error: Invalid character id");
        }

        customerMapper.customerEntityRefreshValues(entity.get(), genreDTO);

        Customer entitySaved = customerRepository.save(entity.get());

        return customerMapper.customerEntity2DTO(entitySaved);
    }
}
