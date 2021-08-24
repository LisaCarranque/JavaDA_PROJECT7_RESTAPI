package com.nnk.springboot.IT.services;

import com.nnk.springboot.Application;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.TradeService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {Application.class,  TradeService.class})
@EnableJpaRepositories(basePackageClasses = {TradeRepository.class})
@EntityScan(basePackageClasses = {Trade.class})
@ContextConfiguration
public class TradeServiceIT {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private TradeRepository tradeRepository;

    @AfterEach
    public void deleteAll() {
        tradeService.clearDataBase();
    }

    @Test
    public void save() {
        Trade trade = Trade.builder().tradeId(1).type("Trade Type Test").buyQuantity(10.00).build();
        Trade tradeSaved = tradeService.add(trade);
        assertNotNull(tradeSaved);
        assertEquals(tradeSaved.getType(), "Trade Type Test");
    }

    @Test
    public void list() {
        List<Trade> trades = tradeService.findAll();
        assertNotNull(trades);
    }

    @Test
    public void delete() {
        List<Trade> trades = tradeService.findAll();
        assertNotNull(trades);
        int size = trades.size();
        Trade trade = tradeService.getById(200);
        tradeService.delete(trade);
        List<Trade> tradeAfterDelete = tradeService.findAll();
        assertEquals(size-1, tradeAfterDelete.size());
    }

}