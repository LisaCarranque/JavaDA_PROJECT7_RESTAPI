package com.nnk.springboot.IT.services;

import com.nnk.springboot.Application;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.BidListService;
import com.nnk.springboot.services.TradeService;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
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
public class BidListServiceIT {


    @Autowired
    private  BidListService bidListService;

    @Autowired
    private BidListRepository bidListRepository;

    @AfterEach
    public void deleteAll() {
        bidListService.clearDataBase();
    }

    @Test
    public void save() {
        BidList bidList = BidList.builder().bidListId(1).type("Bid Type Test").account("Account").build();
        BidList bidListSaved = bidListService.add(bidList);
        assertNotNull(bidListSaved);
        assertEquals(bidListSaved.getType(), "Bid Type Test");
    }

    @Test
    public void list() {
        List<BidList> bidLists = bidListService.findAll();
        assertNotNull(bidLists);
    }

    @Test
    public void delete() {
        List<BidList> bidLists = bidListService.findAll();
        assertNotNull(bidLists);
        int size = bidLists.size();
        BidList bidList = bidListService.getById(200);
        bidListService.delete(bidList);
        List<BidList> bidListAfterDelete = bidListService.findAll();
        assertEquals(size-1, bidListAfterDelete.size());
    }



}