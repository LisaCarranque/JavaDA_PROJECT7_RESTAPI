package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.services.RatingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RatingControllerTest {

    @Mock
    RatingService ratingService;

    @InjectMocks
    RatingController ratingController;

    @Spy
    BindingResult bindingResult;

    @Spy
    Model model;

    @Test
    public void home() {
        ratingController.home(model);
        verify(ratingService, times(1)).findAll();
    }

    @Test
    public void validate() {
        Rating rating = Rating.builder().id(1).sandPRating("Sand P Rating")
                .orderNumber(1).moodysRating("Moodys Rating")
                .fitchRating("Fitch Rating").build();
        ratingController.validate(rating, bindingResult, model);
        verify(ratingService, times(1)).add(rating);
    }

    @Test
    public void showUpdateForm() {
        ratingController.showUpdateForm(1, model);
        verify(ratingService, times(1)).getById(1);
    }

    @Test
    public void updateRuleName() {
        Rating rating = Rating.builder().id(1).sandPRating("Sand P Rating")
                .orderNumber(1).moodysRating("Moodys Rating")
                .fitchRating("Fitch Rating").build();
        ratingController.updateRating(1, rating, bindingResult, model);
        verify(ratingService, times(1)).update(rating);
        verify(ratingService, times(1)).findAll();
    }

    @Test
    public void deleteBid() {
        Rating rating = Rating.builder().id(1).sandPRating("Sand P Rating")
                .orderNumber(1).moodysRating("Moodys Rating")
                .fitchRating("Fitch Rating").build();
        when(ratingService.getById(1)).thenReturn(rating);
        ratingController.deleteRating(1, model);
        verify(ratingService, times(1)).getById(1);
        verify(ratingService, times(1)).delete(rating);
    }
}
