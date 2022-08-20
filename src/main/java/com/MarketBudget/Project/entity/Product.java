package com.MarketBudget.Project.entity;

import com.MarketBudget.Project.entity.user.Commerce;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Where(clause = "product_deleted=false")
@SQLDelete(sql = "UPDATE product SET product_deleted = true WHERE product_id = ?")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String details;
    private String image;
    private Double price;
    private Double quantity;
    private Integer rate;

    @ManyToMany(mappedBy = "products")
    private List<Budget> budgets;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categories", referencedColumnName = "categories_id", nullable = false)
    private Categories category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "commerce", referencedColumnName = "commerce_id", nullable = false)
    private Commerce commerce;

    @OneToMany
    private List<Comments> comments;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;
}