package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService implements ITradeService {

    @Autowired
    TradeRepository tradeRepository;

    @Override
    public List<Trade> findAll() {
        return tradeRepository.findAll();
    }

    @Override
    public Trade add(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public Trade validate(Trade trade) {
        //TODO check valid data
        return null;
    }

    @Override
    public Trade update(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public Trade getById(Integer id) {
        return tradeRepository.getOne(id);
    }

    @Override
    public void delete(Trade trade) {
        tradeRepository.delete(trade);
    }

}
