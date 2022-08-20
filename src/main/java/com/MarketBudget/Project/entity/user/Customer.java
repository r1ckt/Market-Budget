package com.MarketBudget.Project.entity.user;

import com.MarketBudget.Project.entity.Budget;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;


@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE customer SET deleted = true WHERE id = ?")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(unique = true)
    private Integer dni;

    @Column(name = "customer_name")
    private String name;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;
    @Column(nullable = false)
    private String surname;
    private String image;
    @OneToOne(cascade=CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Budget> budget;

}
