package com.MarketBudget.Project.entity;

import com.MarketBudget.Project.entity.user.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE budget SET deleted = true WHERE id = ?")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate creationDate;
    private LocalDate receivedDate;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "budgets_products",
            joinColumns = @JoinColumn(name = "budget_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;


}
