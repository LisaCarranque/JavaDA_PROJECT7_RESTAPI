package com.nnk.springboot.IT.services;

import com.nnk.springboot.Application;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.BidListService;
import com.nnk.springboot.services.RatingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {Application.class,  BidListService.class})
@EnableJpaRepositories(basePackageClasses = {BidListRepository.class})
@EntityScan(basePackageClasses = {BidList.class})
@ContextConfiguration
public class RatingServiceIT {

        @Autowired
        private RatingService ratingService;

        @Autowired
        private RatingRepository ratingRepository;

        @AfterEach
        public void deleteAll() {
            ratingService.clearDataBase();
        }

        @Test
        public void save() {
            Rating rating = Rating.builder().id(1).orderNumber(10).fitchRating("Fitch Rating Test").build();
            Rating ratingSaved = ratingService.add(rating);
            assertNotNull(ratingSaved);
            assertEquals(ratingSaved.getFitchRating(), "Fitch Rating Test");
        }

        @Test
        public void list() {
            List<Rating> ratings = ratingService.findAll();
            assertNotNull(ratings);
        }

        @Test
        public void delete() {
            List<Rating> ratings = ratingService.findAll();
            assertNotNull(ratings);
            int size = ratings.size();
            Rating rating = ratingService.getById(200);
            ratingService.delete(rating);
            List<Rating> ratingAfterDelete = ratingService.findAll();
            assertEquals(size-1, ratingAfterDelete.size());
        }

}