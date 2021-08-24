package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
public class BidListService implements IBidListService {

    @Autowired
    BidListRepository bidListRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<BidList> findAll() {
        log.info("Display all bidLists");
        return bidListRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BidList add(BidList bidList) {
        log.info("Save bidList");
        return bidListRepository.save(bidList);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BidList update(BidList bidList) {
        log.info("Update bidList");
        return bidListRepository.save(bidList);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BidList getById(Integer id) {
        log.info("Get a bidList by id");
        return bidListRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(BidList bidList) {
        log.info("Delete a bidList");
        bidListRepository.delete(bidList);
    }

    /**
     * This method is responsible for removing all bidList from database
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void clearDataBase() {
        bidListRepository.deleteAll();
    }
}
