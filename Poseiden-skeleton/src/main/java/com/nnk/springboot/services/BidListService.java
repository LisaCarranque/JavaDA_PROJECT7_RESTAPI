package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is responsible for managing bidList data by calling BidListRepository methods
 */
@Log4j2
@Service
public class BidListService implements IBidListService {

    @Autowired
    BidListRepository bidListRepository;

    /**
     * This method displays all bidlists by calling findAll method from BidListRepository
     *
     * @return a list of all bidList existing in database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<BidList> findAll() {
        log.info("Display all bidLists");
        return bidListRepository.findAll();
    }

    /**
     * This method adds a bidList by calling save method from BidListRepository
     *
     * @param bidList the bidList to add
     * @return the new bidList saved into database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BidList add(BidList bidList) {
        log.info("Save bidList");
        return bidListRepository.save(bidList);
    }

    /**
     * This method updates a bidList by calling save method from BidListRepository
     *
     * @param bidList the bidList to update
     * @return the updated bidList
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BidList update(BidList bidList) {
        log.info("Update bidList");
        return bidListRepository.save(bidList);
    }

    /**
     * This method selects an existing bidList by id from database by calling getOne method of BidListRepository
     *
     * @param id the id of the targeted bidList
     * @return the selected bidList from database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public BidList getById(Integer id) {
        log.info("Get a bidList by id");
        return bidListRepository.getOne(id);
    }

    /**
     * This method removes a bidList from database by calling delete method from BidListRepository
     *
     * @param bidList the bidList to remove
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(BidList bidList) {
        log.info("Delete a bidList");
        bidListRepository.delete(bidList);
    }

    /**
     * This method is responsible for removing all bidList entries from database
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void clearDataBase() {
        log.info("Clear database");
        bidListRepository.deleteAll();
    }
}
