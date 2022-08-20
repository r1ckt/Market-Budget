package com.MarketBudget.Project.mapper;

import com.MarketBudget.Project.dto.AddressDTO;
import com.MarketBudget.Project.dto.BudgetDTO;
import com.MarketBudget.Project.entity.Budget;
import com.MarketBudget.Project.entity.user.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BudgetMapper {
    public Budget budgetDTO2Entity(BudgetDTO dto) {

        Budget entity = new Budget();
        entity.setName(dto.getName());
        entity.setProducts(dto.getProductList());
        entity.setCreationDate(dto.getCreationDate());
        entity.setReceivedDate(dto.getReceivedDate());
        entity.setTotal(dto.getTotal());
        return entity;
    }

    public BudgetDTO budgetEntity2DTO(Budget entity) {

        BudgetDTO dto = new BudgetDTO();
        dto.setId(entity.getId());
        entity.setName(dto.getName());
        entity.setProducts(dto.getProductList());
        entity.setCreationDate(dto.getCreationDate());
        entity.setReceivedDate(dto.getReceivedDate());
        entity.setTotal(dto.getTotal());

        return dto;
    }

    public List<BudgetDTO> budgetEntityList2DTOList(List<Budget > entities) {

        List<BudgetDTO> dtos = new ArrayList<>();

        for (Budget  entity : entities) {
            dtos.add(this.budgetEntity2DTO(entity));
        }

        return dtos;
    }


    public void budgetEntityRefreshValues(Budget  entity, BudgetDTO dto) {

        entity.setName(dto.getName());
        entity.setProducts(dto.getProductList());
        entity.setCreationDate(dto.getCreationDate());
        entity.setReceivedDate(dto.getReceivedDate());
        entity.setTotal(dto.getTotal());
    }
}
