package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is responsible for managing Rating data in database with Spring Data JPA
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
