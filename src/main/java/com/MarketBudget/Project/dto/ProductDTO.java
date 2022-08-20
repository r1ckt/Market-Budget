package com.MarketBudget.Project.dto;

import com.MarketBudget.Project.entity.Categories;
import com.MarketBudget.Project.entity.Comments;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private Categories categories;
    private String details;
    private String image;
    private Double price;
    private Double quantity;
    private Integer rate;
    private List<Comments> commentsList;
}
