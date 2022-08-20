package com.MarketBudget.Project.mapper;


import com.MarketBudget.Project.dto.ProductDTO;
import com.MarketBudget.Project.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public Product productDTO2Entity(ProductDTO dto) {

        Product entity = new Product();
        entity.setComments(dto.getCommentsList());
        entity.setDetails(dto.getDetails());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());

        return entity;
    }

    public ProductDTO productEntity2DTO(Product entity) {

        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setCommentsList(entity.getComments());
        dto.setDetails(entity.getDetails());
        dto.setQuantity(entity.getQuantity());
        dto.setPrice(entity.getPrice());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());

        return dto;
    }

    public List<ProductDTO > productEntityList2DTOList(List<Product> entities) {

        List<ProductDTO> dtos = new ArrayList<>();

        for (Product entity : entities) {
            dtos.add(this.productEntity2DTO(entity));
        }

        return dtos;
    }


    public void productEntityRefreshValues(Product entity, ProductDTO dto) {
        entity.setComments(dto.getCommentsList());
        entity.setDetails(dto.getDetails());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
    }
}
