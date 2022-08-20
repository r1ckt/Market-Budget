package com.MarketBudget.Project.repository;

import com.MarketBudget.Project.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

        boolean existsByEmail(String email);

        Optional<User> findByEmail(String email);
/*
        @Modifying
        @Query("UPDATE User u SET u.deleted = false WHERE u.id = ?1")
        void enableById(Integer id);
*/
}
