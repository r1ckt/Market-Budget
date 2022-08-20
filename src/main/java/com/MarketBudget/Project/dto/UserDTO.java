package com.MarketBudget.Project.dto;


import com.MarketBudget.Project.entity.user.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String photo;
    private Long dni;
    private String name;
    private String surname;
    private String telephone;
    private LocalDate dateOfBirth;
    private Role role;
}
