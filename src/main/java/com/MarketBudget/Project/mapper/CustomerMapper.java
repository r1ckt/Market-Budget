package com.MarketBudget.Project.mapper;

import com.MarketBudget.Project.dto.CustomerDTO;
import com.MarketBudget.Project.entity.user.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {
    public Customer customerDTO2Entity(CustomerDTO dto) {

        Customer entity = new Customer();
        entity.setAddress(dto.getAddress());
        entity.setBudget(dto.getBudget());
        entity.setSurname(dto.getSurname());
        entity.setDni(dto.getDni());
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());

        return entity;
    }

    public CustomerDTO customerEntity2DTO(Customer entity) {

        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddress());
        dto.setBudget(entity.getBudget());
        dto.setSurname(entity.getSurname());
        dto.setDni(entity.getDni());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());

        return dto;
    }

    public List<CustomerDTO> customerEntityList2DTOList(List<Customer> entities) {

        List<CustomerDTO> dtos = new ArrayList<>();

        for (Customer entity : entities) {
            dtos.add(this.customerEntity2DTO(entity));
        }

        return dtos;
    }


    public void customerEntityRefreshValues(Customer entity, CustomerDTO dto) {
        entity.setAddress(dto.getAddress());
        entity.setBudget(dto.getBudget());
        entity.setSurname(dto.getSurname());
        entity.setDni(dto.getDni());
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
    }
}
