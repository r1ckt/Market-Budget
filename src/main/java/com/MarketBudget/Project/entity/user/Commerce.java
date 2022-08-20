package com.MarketBudget.Project.entity.user;

import com.MarketBudget.Project.entity.Comments;
import com.MarketBudget.Project.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE commerce SET deleted = true WHERE id = ?")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Commerce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commerce_id", nullable = false)
    private Long id;
    @Column(name = "commerce_name", nullable = false)
    private String name;
    private Integer rate;
    private String image;

    @OneToOne(cascade=CascadeType.ALL)
    private Address address;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;

    @OneToMany(mappedBy = "commerce", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToMany
    private List<Comments> comments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
}
