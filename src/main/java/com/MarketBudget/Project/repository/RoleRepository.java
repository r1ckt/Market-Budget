package com.MarketBudget.Project.repository;

import com.MarketBudget.Project.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    public Role findByName(String name);
}
