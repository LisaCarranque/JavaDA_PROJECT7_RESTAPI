package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
public class RatingService implements IRatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Rating> findAll() {
        log.info("Find all ratings.");
        return ratingRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Rating add(Rating rating) {
        log.info("Save a rating.");
        return ratingRepository.save(rating);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Rating update(Rating rating) {
        log.info("Update a rating");
        return ratingRepository.save(rating);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Rating getById(Integer id) {
        log.info("Find a rating by id");
        return ratingRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(Rating rating) {
        log.info("Delete a rating");
        ratingRepository.delete(rating);
    }


    /**
     * This method is responsible for removing all bidList from database
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void clearDataBase() {
        ratingRepository.deleteAll();
    }
}
