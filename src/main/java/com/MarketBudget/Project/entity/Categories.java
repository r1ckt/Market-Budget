package com.MarketBudget.Project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE categories SET deleted = true WHERE id = ?")
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id")
    private Long id;

    private String name;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;

    private String image;


}
