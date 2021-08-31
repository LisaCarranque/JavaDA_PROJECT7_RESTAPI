package com.nnk.springboot.TU.controllers;

import com.nnk.springboot.controllers.CurveController;
import com.nnk.springboot.controllers.TradeController;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.CurveService;
import com.nnk.springboot.services.TradeService;
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
public class TradeControllerTest {

    @Mock
    TradeService tradeService;

    @InjectMocks
    TradeController tradeController;

    @Spy
    BindingResult bindingResult;

    @Spy
    Model model;

    @Test
    public void home() {
        tradeController.home(model);
        verify(tradeService, times(1)).findAll();
    }

    @Test
    public void validate() {
        Trade trade = Trade.builder().tradeId(1).type("type").buyQuantity(10.00)
                .account("account").build();
        tradeController.validate(trade, bindingResult, model);
        verify(tradeService, times(1)).add(trade);
    }

    @Test
    public void showUpdateForm() {
        Trade trade = Trade.builder().tradeId(1).type("type").buyQuantity(10.00)
                .account("account").build();
        tradeController.showUpdateForm(1, model);
        verify(tradeService, times(1)).getById(1);
    }

    @Test
    public void updateBid() {
        Trade trade = Trade.builder().tradeId(1).type("type").buyQuantity(10.00)
                .account("account").build();
        tradeController.updateTrade(1, trade, bindingResult, model);
        verify(tradeService, times(1)).update(trade);
        verify(tradeService, times(1)).findAll();
    }

    @Test
    public void deleteBid() {
        Trade trade = Trade.builder().tradeId(1).type("type").buyQuantity(10.00)
                .account("account").build();
        when(tradeService.getById(1)).thenReturn(trade);
        tradeController.deleteTrade(1, model);

        verify(tradeService, times(1)).getById(1);
        verify(tradeService, times(1)).delete(trade);
    }


}
