package com.MarketBudget.Project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Long id;
    private String Country;
    private Integer zipCode;
    private String city;
}
