package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is responsible for managing Rating data in database with Spring Data JPA
 */
public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
