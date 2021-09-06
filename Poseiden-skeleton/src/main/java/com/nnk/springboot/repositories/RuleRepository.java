package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is responsible for managing Rule data in database with Spring Data JPA
 */
@Repository
public interface RuleRepository extends JpaRepository<Rule, Integer> {
}
