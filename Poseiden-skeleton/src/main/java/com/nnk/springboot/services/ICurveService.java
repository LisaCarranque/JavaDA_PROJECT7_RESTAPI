package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;

public interface ICurveService {

    //service find all
    public List<CurvePoint> findAll();

    //service add bid
    public CurvePoint add(CurvePoint curvePoint);

    //service check data
    public CurvePoint validate(CurvePoint curvePoint);

    //service update bid
    public CurvePoint update(CurvePoint curvePoint);

    // service update bid id
    public CurvePoint getById(Integer id);

    // service delete bid
    public void delete(CurvePoint curvePoint);

}
