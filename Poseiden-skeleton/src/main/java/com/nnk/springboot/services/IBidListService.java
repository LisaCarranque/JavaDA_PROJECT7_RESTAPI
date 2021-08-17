package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;

import java.util.List;

public interface IBidListService {

    //service find all
    public List<BidList> findAll();

    //service add bid
    public BidList add(BidList bidList);

    //service check data
    public BidList validate(BidList bidList);

    //service update bid
    public BidList update(BidList bidList);

    // service update bid id
    public BidList getById(Integer id);

    // service delete bid
    public void delete(BidList bidList);

}
