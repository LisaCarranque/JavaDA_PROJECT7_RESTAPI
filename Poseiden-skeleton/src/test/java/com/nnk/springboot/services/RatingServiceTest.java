package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {

    @Mock
    RatingRepository ratingRepository;

    @InjectMocks
    RatingService ratingService;

    @Test
    public void findAll() {
        List<Rating> rating = ratingService.findAll();
        verify(ratingRepository, times(1)).findAll();
    }

    @Test
    public void add() {
        Rating rating = Rating.builder().id(1).fitchRating("Fitch Rating")
                .moodysRating("Moodys Rating").orderNumber(1).sandPRating("Sand PRating").build();
        ratingService.add(rating);
        verify(ratingRepository, times(1)).save(rating);
    }

    @Test
    public void update() {
        Rating rating = Rating.builder().id(1).fitchRating("Fitch Rating")
                .moodysRating("Moodys Rating").orderNumber(1).sandPRating("Sand PRating").build();
        ratingService.update(rating);
        verify(ratingRepository, times(1)).save(rating);
    }

    @Test
    public void getById() {
        ratingService.getById(1);
        verify(ratingRepository, times(1)).getOne(1);
    }

    @Test
    public void delete() {
        Rating rating = Rating.builder().id(1).fitchRating("Fitch Rating")
                .moodysRating("Moodys Rating").orderNumber(1).sandPRating("Sand PRating").build();
        ratingService.delete(rating);
        verify(ratingRepository, times(1)).delete(rating);
    }

}
