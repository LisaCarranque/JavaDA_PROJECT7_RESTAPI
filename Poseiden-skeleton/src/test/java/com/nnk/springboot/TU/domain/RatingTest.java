package com.nnk.springboot.TU.domain;

import com.nnk.springboot.domain.Rating;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RatingTest {

    @Test
    public void setRating() {
        Rating rating = Rating.builder().sandPRating("Sand Rating")
                .moodysRating("Moody Rating")
                .fitchRating("Fitch Rating")
                .orderNumber(10).build();
        assertEquals("Fitch Rating", rating.getFitchRating());
        assertEquals("Moody Rating", rating.getMoodysRating());
        assertEquals("Sand Rating", rating.getSandPRating());
        assertEquals(Integer.valueOf(10), rating.getOrderNumber());
    }

    @Test
    public void getRating() {
        Rating rating = Rating.builder().build();
                rating.setSandPRating("Sand Rating");
                rating.setMoodysRating("Moody Rating");
                rating.setFitchRating("Fitch Rating");
                rating.setOrderNumber(10);
        assertEquals("Fitch Rating", rating.getFitchRating());
        assertEquals("Moody Rating", rating.getMoodysRating());
        assertEquals("Sand Rating", rating.getSandPRating());
        assertEquals(Integer.valueOf(10), rating.getOrderNumber());
    }

}
