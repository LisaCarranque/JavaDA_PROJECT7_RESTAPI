package com.nnk.springboot.IT.controllers;

import com.nnk.springboot.controllers.CurveController;
import com.nnk.springboot.controllers.RatingController;
import com.nnk.springboot.services.CurveService;
import com.nnk.springboot.services.ICurveService;
import com.nnk.springboot.services.IRatingService;
import com.nnk.springboot.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {RatingController.class, RatingService.class, IRatingService.class})
@EntityScan(basePackageClasses = {RatingService.class})
@EnableAutoConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class RatingControllerIT {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private IRatingService ratingService;

    @WithMockUser("jeanneDupont")
    @Test
    public void listRating() throws Exception {
        this.mvc.perform(get("/rating/list"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @WithMockUser("jeanneDupont")
    @Test
    public void addRating() throws Exception {
        this.mvc.perform(get("/rating/add"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @WithMockUser("jeanneDupont")
    @Test
    public void deleteRating() throws Exception {
        this.mvc.perform(get("/rating/delete/201"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/rating/list"))
                .andReturn();
    }

}
