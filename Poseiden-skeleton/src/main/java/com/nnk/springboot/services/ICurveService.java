package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;

public interface ICurveService {

    public List<CurvePoint> findAll();

    public CurvePoint add(CurvePoint curvePoint);

    public CurvePoint update(CurvePoint curvePoint);

    public CurvePoint getById(Integer id);

    public void delete(CurvePoint curvePoint);

}
