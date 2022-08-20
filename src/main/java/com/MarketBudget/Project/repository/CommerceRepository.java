package com.MarketBudget.Project.repository;

import com.MarketBudget.Project.entity.user.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommerceRepository extends JpaRepository<Commerce, Long> {
}
