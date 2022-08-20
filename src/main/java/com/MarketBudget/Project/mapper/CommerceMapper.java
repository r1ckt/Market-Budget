package com.MarketBudget.Project.mapper;

import com.MarketBudget.Project.dto.BudgetDTO;
import com.MarketBudget.Project.dto.CommerceDTO;
import com.MarketBudget.Project.entity.Budget;
import com.MarketBudget.Project.entity.user.Commerce;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommerceMapper {
    public Commerce commerceDTO2Entity(CommerceDTO dto) {

        Commerce entity = new Commerce();
        entity.setName(dto.getName());
        entity.setProducts(dto.getProductList());
        entity.setAddress(dto.getAddress());
        entity.setComments(dto.getComments());
        entity.setRate(dto.getRate());
        entity.setImage(dto.getImage());
        return entity;
    }

    public CommerceDTO commerceEntity2DTO(Commerce entity) {

        CommerceDTO dto = new CommerceDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setProductList(entity.getProducts());
        dto.setAddress(entity.getAddress());
        dto.setComments(entity.getComments());
        dto.setRate(entity.getRate());
        dto.setImage(entity.getImage());

        return dto;
    }

    public List<CommerceDTO> commerceEntityList2DTOList(List<Commerce > entities) {

        List<CommerceDTO> dtos = new ArrayList<>();

        for (Commerce  entity : entities) {
            dtos.add(this.commerceEntity2DTO(entity));
        }

        return dtos;
    }


    public void commerceEntityRefreshValues(Commerce  entity, CommerceDTO dto) {

        entity.setName(dto.getName());
        entity.setProducts(dto.getProductList());
        entity.setAddress(dto.getAddress());
        entity.setComments(dto.getComments());
        entity.setRate(dto.getRate());
        entity.setImage(dto.getImage());
    }
}
