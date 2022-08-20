package com.MarketBudget.Project.repository;

import com.MarketBudget.Project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select * from Product where Product.name = %:name%", nativeQuery = true)
    List<Product> findByName(@Param("name") String name);

}
