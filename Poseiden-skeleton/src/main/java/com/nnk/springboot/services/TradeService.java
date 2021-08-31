package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is responsible for managing Trade data by calling TradeRepository methods
 */
@Service
@Log4j2
public class TradeService implements ITradeService {

    @Autowired
    TradeRepository tradeRepository;

    /**
     * This method displays all trades by calling findAll method from TradeRepository
     * @return a list of all trades existing in database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Trade> findAll() {
        log.info("Find all trades");
        return tradeRepository.findAll();
    }

    /**
     * This method adds a trade by calling save method from TradeRepository
     * @param trade the trade to add
     * @return the new trade saved into database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Trade add(Trade trade) {
        log.info("Save a trade");
        return tradeRepository.save(trade);
    }

    /**
     * This method updates a trade by calling save method from TradeRepository
     * @param trade the trade to update
     * @return the updated trade
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Trade update(Trade trade) {
        log.info("Update a trade");
        return tradeRepository.save(trade);
    }

    /**
     * This method selects an existing trade by id from database by calling getOne method of TradeRepository
     * @param id the id of the targeted trade
     * @return the selected trade from database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Trade getById(Integer id) {
        log.info("Find a trade by id");
        return tradeRepository.getOne(id);
    }

    /**
     * This method removes a trade from database by calling delete method from TradeRepository
     * @param trade the trade to remove
     */
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
        log.info("Clear database");
        tradeRepository.deleteAll();
    }


}
