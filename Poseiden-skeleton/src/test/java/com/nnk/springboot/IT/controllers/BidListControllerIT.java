package com.nnk.springboot.IT.controllers;

import com.nnk.springboot.controllers.BidListController;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidListService;
import com.nnk.springboot.services.IBidListService;
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

@SpringBootTest(classes = {BidListController.class, BidListService.class, IBidListService.class})
@EntityScan(basePackageClasses = {BidList.class})
@EnableAutoConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BidListControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IBidListService bidListService;

    @WithMockUser("jeanneDupont")
    @Test
    public void listBidList() throws Exception {
        this.mvc.perform(get("/bidList/list"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @WithMockUser("jeanneDupont")
    @Test
    public void addBidList() throws Exception {
        this.mvc.perform(get("/bidList/add"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @WithMockUser("jeanneDupont")
    @Test
    public void deleteBidList() throws Exception {
        this.mvc.perform(get("/bidList/delete/201"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/bidList/list"))
                .andReturn();
    }

}
