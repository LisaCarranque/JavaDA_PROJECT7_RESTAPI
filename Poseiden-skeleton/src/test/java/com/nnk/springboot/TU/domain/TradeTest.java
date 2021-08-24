package com.nnk.springboot.TU.domain;

import com.nnk.springboot.domain.Trade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TradeTest {

    @Test
    public void setTrade() {
        Trade trade = Trade.builder().tradeId(1).account("Account")
                .type("Type").buyQuantity(10.00).build();
        assertEquals(Integer.valueOf(1), trade.getTradeId());
        assertEquals("Account", trade.getAccount());
        assertEquals("Type", trade.getType());
        assertEquals(Double.valueOf(10.00), trade.getBuyQuantity());
    }

    @Test
    public void getTrade() {
        Trade trade = Trade.builder().build();
        trade.setTradeId(1);
        trade.setAccount("Account");
        trade.setType("Type");
        trade.setBuyQuantity(10.00);
        assertEquals(Integer.valueOf(1), trade.getTradeId());
        assertEquals("Account", trade.getAccount());
        assertEquals("Type", trade.getType());
        assertEquals(Double.valueOf(10.00), trade.getBuyQuantity());
    }

}
