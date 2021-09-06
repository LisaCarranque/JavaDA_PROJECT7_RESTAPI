package com.nnk.springboot.IT.controllers;

import com.nnk.springboot.IT.services.TradeServiceIT;
import com.nnk.springboot.controllers.RatingController;
import com.nnk.springboot.controllers.TradeController;
import com.nnk.springboot.services.IRatingService;
import com.nnk.springboot.services.ITradeService;
import com.nnk.springboot.services.RatingService;
import com.nnk.springboot.services.TradeService;
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

@SpringBootTest(classes = {TradeController.class, TradeService.class, ITradeService.class})
@EntityScan(basePackageClasses = {RatingService.class})
@EnableAutoConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TradeControllerIT {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ITradeService tradeService;

    @WithMockUser("jeanneDupont")
    @Test
    public void listTrade() throws Exception {
        this.mvc.perform(get("/trade/list"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @WithMockUser("jeanneDupont")
    @Test
    public void addTrade() throws Exception {
        this.mvc.perform(get("/trade/add"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @WithMockUser("jeanneDupont")
    @Test
    public void deleteTrade() throws Exception {
        this.mvc.perform(get("/trade/delete/201"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/trade/list"))
                .andReturn();
    }


}
