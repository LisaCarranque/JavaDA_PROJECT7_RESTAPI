package com.nnk.springboot;

import com.nnk.springboot.domain.*;
import com.nnk.springboot.services.IUserService;
import com.nnk.springboot.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Log4j2
@Configuration
@ComponentScan({"com.nnk.springboot"})
@EnableAutoConfiguration
@EntityScan(basePackageClasses = {BidList.class, CurvePoint.class, Rating.class,
        Rule.class, Trade.class, User.class, IUserService.class, UserService.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
