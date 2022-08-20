package com.MarketBudget.Project.entity.user;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id = ?")
@Getter
@Setter
@Table(name = "user", indexes = {@Index(name = "idx_email", columnList = "email")})
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;

    @Column(name = "email", length = 60, unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;


    @OneToOne
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Commerce commerce;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;

}