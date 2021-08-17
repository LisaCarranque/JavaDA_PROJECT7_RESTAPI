package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BidListServiceTest {

    @Mock
    BidListRepository bidListRepository;

    @InjectMocks
    BidListService bidListService;

    @Test
    public void findAll() {
        List<BidList> bidList = bidListService.findAll();
        verify(bidListRepository, times(1)).findAll();
    }

    @Test
    public void add() {
        BidList bidList = BidList.builder().bidListId(1).bidQuantity(10.00).build();
        bidListService.add(bidList);
        verify(bidListRepository, times(1)).save(bidList);
    }

    @Test
    public void update() {
        BidList bidList = BidList.builder().bidListId(1).bidQuantity(10.00).build();
        bidListService.update(bidList);
        verify(bidListRepository, times(1)).save(bidList);
    }

    @Test
    public void getById() {
        bidListService.getById(1);
        verify(bidListRepository, times(1)).getOne(1);
    }

    @Test
    public void delete() {
        BidList bidList = BidList.builder().bidListId(1).bidQuantity(10.00).build();
        bidListService.delete(bidList);
        verify(bidListRepository, times(1)).delete(bidList);
    }

}
