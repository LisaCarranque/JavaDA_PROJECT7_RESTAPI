package com.nnk.springboot.application;

import com.nnk.springboot.controllers.BidListController;
import com.nnk.springboot.controllers.CurveController;
import com.nnk.springboot.controllers.TradeController;
import com.nnk.springboot.controllers.UserController;
import com.nnk.springboot.domain.*;
import com.nnk.springboot.repositories.*;
import com.nnk.springboot.services.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Log4j2
@Configuration
@ComponentScan({"com.nnk.springboot"})
@EnableAutoConfiguration
@EntityScan(basePackageClasses = {BidList.class, CurvePoint.class, Rating.class,
		RuleName.class, Trade.class, User.class})
@EnableJpaRepositories(basePackageClasses = {BidListRepository.class, CurvePointRepository.class,
		RatingRepository.class, RuleNameRepository.class, TradeRepository.class, UserRepository.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
