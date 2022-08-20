package com.MarketBudget.Project.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Address {
    @Id
    private Long id;
    private String Country;
    private Integer zipCode;
    private String city;
}
