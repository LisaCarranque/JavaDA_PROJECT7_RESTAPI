package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;

import java.util.List;

public interface IBidListService {

    public List<BidList> findAll();

    public BidList add(BidList bidList);

    public BidList update(BidList bidList);

    public BidList getById(Integer id);

    public void delete(BidList bidList);

}
