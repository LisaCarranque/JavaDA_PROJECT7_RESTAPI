package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;

import java.util.List;

public interface ITradeService {

    public List<Trade> findAll();

    public Trade add(Trade trade);

    public Trade update(Trade trade);

    public Trade getById(Integer id);

    public void delete(Trade trade);

}
