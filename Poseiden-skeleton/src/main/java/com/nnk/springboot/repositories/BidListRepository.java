package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is responsible for managing BidList data in database with Spring Data JPA
 */
public interface BidListRepository extends JpaRepository<BidList, Integer> {

}
