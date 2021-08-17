package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurveService implements  ICurveService {

    @Autowired
    CurvePointRepository curvePointRepository;

    @Override
    public List<CurvePoint> findAll() {
        return curvePointRepository.findAll();
    }

    @Override
    public CurvePoint add(CurvePoint curvePoint) {
        return curvePointRepository.save(curvePoint);
    }

    @Override
    public CurvePoint validate(CurvePoint curvePoint) {
        //TODO check valid data
        return null;
    }

    @Override
    public CurvePoint update(CurvePoint curvePoint) {
        return curvePointRepository.save(curvePoint);
    }

    @Override
    public CurvePoint getById(Integer id) {
        return curvePointRepository.getOne(id);
    }

    @Override
    public void delete(CurvePoint curvePoint) {
        curvePointRepository.delete(curvePoint);
    }
}
