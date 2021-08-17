package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService implements IRatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating add(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating validate(Rating rating) {
        //TODO check valid data
        return null;
    }

    @Override
    public Rating update(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getById(Integer id) {
        return ratingRepository.getOne(id);
    }

    @Override
    public void delete(Rating rating) {
        ratingRepository.delete(rating);
    }
}
