package com.MarketBudget.Project.dto;

import com.MarketBudget.Project.entity.Comments;
import com.MarketBudget.Project.entity.Product;
import com.MarketBudget.Project.entity.user.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommerceDTO {
    private Long id;
    private String name;
    private String image;
    private Address address;
    private Integer rate;
    private List<Product> productList;
    private List<Comments> comments;
}
