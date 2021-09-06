package com.nnk.springboot.IT.controllers;

import com.nnk.springboot.controllers.UserController;
import com.nnk.springboot.services.*;
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

@SpringBootTest(classes = {UserController.class, UserService.class, IUserService.class})
@EntityScan(basePackageClasses = {UserService.class})
@EnableAutoConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IUserService userService;

    @WithMockUser("jeanneDupont")
    @Test
    public void listUser() throws Exception {
        this.mvc.perform(get("/user/list"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @WithMockUser("jeanneDupont")
    @Test
    public void addUser() throws Exception {
        this.mvc.perform(get("/user/add"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @WithMockUser("jeanneDupont")
    @Test
    public void deleteUser() throws Exception {
        this.mvc.perform(get("/user/delete/201"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/user/list"))
                .andReturn();
    }

}
