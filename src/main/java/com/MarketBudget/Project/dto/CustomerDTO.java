package com.MarketBudget.Project.dto;

import com.MarketBudget.Project.entity.Budget;
import com.MarketBudget.Project.entity.user.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTO {
    private Long id;
    private Integer dni;
    private String name;
    private String image;
    private Address address;
    private List<Budget> budget;
    private String surname;
}
