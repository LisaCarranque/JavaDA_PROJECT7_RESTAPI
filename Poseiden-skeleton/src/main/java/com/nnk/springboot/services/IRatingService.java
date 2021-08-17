package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;

import java.util.List;

public interface IRatingService {

    public List<Rating> findAll();

    public Rating add(Rating rating);

    public Rating validate(Rating rating);

    public Rating update(Rating rating);

    public Rating getById(Integer id);

    public void delete(Rating rating);
}
