package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is responsible for managing Rating data by calling RatingRepository methods
 */
@Service
@Log4j2
public class RatingService implements IRatingService {

    @Autowired
    RatingRepository ratingRepository;

    /**
     * This method displays all ratings by calling findAll method from RatingRepository
     * @return a list of all rating existing in database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Rating> findAll() {
        log.info("Find all ratings.");
        return ratingRepository.findAll();
    }

    /**
     * This method adds a rating by calling save method from RatingRepository
     * @param rating the rating to add
     * @return the new rating saved into database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Rating add(Rating rating) {
        log.info("Save a rating.");
        return ratingRepository.save(rating);
    }

    /**
     * This method updates a rating by calling save method from RatingRepository
     * @param rating the rating to update
     * @return the updated rating
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Rating update(Rating rating) {
        log.info("Update a rating");
        return ratingRepository.save(rating);
    }

    /**
     * This method selects an existing rating by id from database by calling getOne method of RatingRepository
     * @param id the id of the targeted rating
     * @return the selected rating from database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Rating getById(Integer id) {
        log.info("Find a rating by id");
        return ratingRepository.getOne(id);
    }

    /**
     * This method removes a rating from database by calling delete method from RatingRepository
     * @param rating the rating to remove
     */
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
        log.info("Clear database");
        ratingRepository.deleteAll();
    }
}
