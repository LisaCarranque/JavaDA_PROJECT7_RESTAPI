package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
public class TradeService implements ITradeService {

    @Autowired
    TradeRepository tradeRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Trade> findAll() {
        log.info("Find all trades");
        return tradeRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Trade add(Trade trade) {
        log.info("Save a trade");
        return tradeRepository.save(trade);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Trade update(Trade trade) {
        log.info("Update a trade");
        return tradeRepository.save(trade);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Trade getById(Integer id) {
        log.info("Find a trade by id");
        return tradeRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(Trade trade) {
        log.info("Delete a trade");
        tradeRepository.delete(trade);
    }

    /**
     * This method is responsible for removing all trades from database
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void clearDataBase() {
        tradeRepository.deleteAll();
    }


}
