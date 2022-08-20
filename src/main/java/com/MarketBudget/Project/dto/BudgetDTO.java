package com.MarketBudget.Project.dto;

import com.MarketBudget.Project.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class BudgetDTO {
    private Long id;
    private String name;
    private Set<Product> productList;
    private LocalDate creationDate;
    private LocalDate receivedDate;
    private Double total;

}
