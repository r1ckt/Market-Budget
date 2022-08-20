package com.MarketBudget.Project.repository;

import com.MarketBudget.Project.entity.Budget;
import com.MarketBudget.Project.entity.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {


    List<Budget> findByCustomer(Customer customer);
}
