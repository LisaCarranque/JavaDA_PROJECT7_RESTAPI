package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.CurvePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is responsible for managing Curve data in database with Spring Data JPA
 */
@Repository
public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {

}
