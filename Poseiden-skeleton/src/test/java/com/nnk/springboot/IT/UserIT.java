package com.nnk.springboot.IT;

import com.nnk.springboot.application.Application;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.BidListService;
import com.nnk.springboot.services.IBidListService;
import com.nnk.springboot.services.IUserService;
import com.nnk.springboot.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.jetty.security.UserRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, UserService.class, IUserService.class})
@EntityScan(basePackageClasses = {User.class})
public class UserIT {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void tradeTest() {
        User user = User.builder().id(1).username("Username")
                .fullname("Fullname").password("password").role("role").build();

        // Save
        user = userRepository.save(user);
        Assert.assertNotNull(user.getId());
        Assert.assertTrue(user.getUsername().equals("Username"));

        // Update
        user.setUsername("User Username Update");
        user = userRepository.save(user);
        Assert.assertTrue(user.getUsername().equals("User Username Update"));

        // Find
        List<User> listResult = userRepository.findAll();
        Assert.assertTrue(listResult.size() > 0);

        // Delete
        Integer id = user.getId();
        userRepository.delete(user);
        Optional<User> userList = userRepository.findById(id);
        Assert.assertFalse(userList.isPresent());
    }


}
