package com.nnk.springboot.TU.controllers;

import com.nnk.springboot.controllers.BidListController;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BidListControllerTest {

    @Mock
    BidListService bidListService;

    @InjectMocks
    BidListController bidListController;

    @Spy
    BindingResult bindingResult;

    @Spy
    Model model;

    @Test
    public void home() {
        bidListController.home(model);
        verify(bidListService, times(1)).findAll();
    }

    @Test
    public void validate() {
        BidList bidList = BidList.builder().bidListId(1).bidQuantity(10.00).build();
        bidListController.validate(bidList, bindingResult, model);
        verify(bidListService, times(1)).add(bidList);
    }

    @Test
    public void showUpdateForm() {
        BidList bidList = BidList.builder().bidListId(1).bidQuantity(10.00).build();
        bidListController.showUpdateForm(1, model);
        verify(bidListService, times(1)).getById(1);
    }

    @Test
    public void updateBid() {
        BidList bidList = BidList.builder().bidListId(1).bidQuantity(10.00).build();
        bidListController.updateBid(1, bidList, bindingResult, model);
        verify(bidListService, times(1)).update(bidList);
        verify(bidListService, times(1)).findAll();
    }

    @Test
    public void deleteBid() {
        BidList bidList = BidList.builder().bidListId(1).bidQuantity(10.00).build();
        when(bidListService.getById(1)).thenReturn(bidList);
        bidListController.deleteBid(1, model);

        verify(bidListService, times(1)).getById(1);
        verify(bidListService, times(1)).delete(bidList);
    }


}
