package com.nnk.springboot.TU.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.TradeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {

    @Mock
    TradeRepository tradeRepository;

    @InjectMocks
    TradeService  tradeService;

    @Test
    public void findAll() {
        List<Trade> trade = tradeService.findAll();
        verify(tradeRepository, times(1)).findAll();
    }

    @Test
    public void add() {
        Trade trade = Trade.builder().tradeId(1).type("type").buyQuantity(10.00)
                .account("account").build();
        tradeService.add(trade);
        verify(tradeRepository, times(1)).save(trade);
    }

    @Test
    public void update() {
        Trade trade = Trade.builder().tradeId(1).type("type").buyQuantity(10.00)
                .account("account").build();
        tradeService.update(trade);
        verify(tradeRepository, times(1)).save(trade);
    }

    @Test
    public void getById() {
        tradeService.getById(1);
        verify(tradeRepository, times(1)).getOne(1);
    }

    @Test
    public void delete() {
        Trade trade = Trade.builder().tradeId(1).type("type").buyQuantity(10.00)
                .account("account").build();
        tradeService.delete(trade);
        verify(tradeRepository, times(1)).delete(trade);
    }

}
