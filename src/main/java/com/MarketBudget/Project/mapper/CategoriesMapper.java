package com.MarketBudget.Project.mapper;

import com.MarketBudget.Project.dto.BudgetDTO;
import com.MarketBudget.Project.dto.CategoriesDTO;
import com.MarketBudget.Project.entity.Budget;
import com.MarketBudget.Project.entity.Categories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriesMapper {
    public Categories categoriesDTO2Entity(CategoriesDTO dto) {

        Categories entity = new Categories();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }

    public CategoriesDTO categoriesEntity2DTO(Categories entity) {

        CategoriesDTO dto = new CategoriesDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());

        return dto;
    }

    public List<CategoriesDTO> categoriesEntityList2DTOList(List<Categories > entities) {

        List<CategoriesDTO> dtos = new ArrayList<>();

        for (Categories   entity : entities) {
            dtos.add(this.categoriesEntity2DTO(entity));
        }

        return dtos;
    }


    public void categoriesEntityRefreshValues(Categories   entity, CategoriesDTO dto) {

        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
    }
}
