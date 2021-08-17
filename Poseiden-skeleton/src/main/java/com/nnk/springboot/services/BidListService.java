package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidListService implements IBidListService {

    @Autowired
    BidListRepository bidListRepository;

    @Override
    public List<BidList> findAll() {
        return bidListRepository.findAll();
    }

    @Override
    public BidList add(BidList bidList) {
        return bidListRepository.save(bidList);
    }

    @Override
    public BidList validate(BidList bidList) {
        //TODO check valid data
        return null;
    }

    @Override
    public BidList update(BidList bidList) {
        return bidListRepository.save(bidList);
    }

    @Override
    public BidList getById(Integer id) {
        return bidListRepository.getOne(id);
    }

    @Override
    public void delete(BidList bidList) {
         bidListRepository.delete(bidList);
    }
}
