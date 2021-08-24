package com.nnk.springboot.IT.controllers;

import com.nnk.springboot.controllers.BidListController;
import com.nnk.springboot.controllers.CurveController;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidListService;
import com.nnk.springboot.services.CurveService;
import com.nnk.springboot.services.IBidListService;
import com.nnk.springboot.services.ICurveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {CurveController.class, CurveService.class, ICurveService.class})
@EntityScan(basePackageClasses = {CurveService.class})
@EnableAutoConfiguration
@AutoConfigureMockMvc
public class CurveControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ICurveService curveService;

    @WithMockUser("jeanneDupont")
    @Test
    public void list_bidList() throws Exception {
        this.mvc.perform(get("/curvePoint/list"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @WithMockUser("jeanneDupont")
    @Test
    public void addBidList() throws Exception {
        this.mvc.perform(get("/curvePoint/add"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @WithMockUser("jeanneDupont")
    @Test
    public void deleteBidList() throws Exception {
        this.mvc.perform(get("/curvePoint/delete/201"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/curvePoint/list"))
                .andReturn();
    }

}
