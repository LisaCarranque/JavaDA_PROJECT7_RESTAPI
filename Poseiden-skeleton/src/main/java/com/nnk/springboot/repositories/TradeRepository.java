package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is responsible for managing Trade data in database with Spring Data JPA
 */
public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
