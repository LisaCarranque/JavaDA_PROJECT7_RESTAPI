package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
public class CurveService implements ICurveService {

    @Autowired
    CurvePointRepository curvePointRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<CurvePoint> findAll() {
        log.info("Find all curvePoints");
        return curvePointRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CurvePoint add(CurvePoint curvePoint) {
        log.info("Add curvePoint");
        return curvePointRepository.save(curvePoint);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CurvePoint update(CurvePoint curvePoint) {
        log.info("Update curvePoint");
        return curvePointRepository.save(curvePoint);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CurvePoint getById(Integer id) {
        log.info("Find curvePoint by id");
        return curvePointRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(CurvePoint curvePoint) {
        log.info("Delete curvePoint");
        curvePointRepository.delete(curvePoint);
    }

    /**
     * This method is responsible for removing all curvePoint from database
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void clearDataBase() {
        curvePointRepository.deleteAll();
    }
}
