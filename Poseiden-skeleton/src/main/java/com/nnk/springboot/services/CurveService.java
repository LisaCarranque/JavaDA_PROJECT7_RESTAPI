package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is responsible for managing Curve data by calling CurvePointRepository methods
 */
@Service
@Log4j2
public class CurveService implements ICurveService {

    @Autowired
    CurvePointRepository curvePointRepository;

    /**
     * This method displays all curvePoint entries by calling findAll method from CurvePointRepository
     * @return a list of all curvePoint entries existing in database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<CurvePoint> findAll() {
        log.info("Find all curvePoints");
        return curvePointRepository.findAll();
    }

    /**
     * This method adds a curvePoint by calling save method from CurvePointRepository
     * @param curvePoint the curvePoint to add
     * @return the new curvePoint saved into database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CurvePoint add(CurvePoint curvePoint) {
        log.info("Add curvePoint");
        return curvePointRepository.save(curvePoint);
    }

    /**
     * This method updates a curvePoint by calling save method from CurvePointRepository
     * @param curvePoint the curvePoint to update
     * @return the updated curvePoint
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CurvePoint update(CurvePoint curvePoint) {
        log.info("Update curvePoint");
        return curvePointRepository.save(curvePoint);
    }

    /**
     * This method selects an existing curvePoint by id from database by calling getOne method of CurvePointRepository
     * @param id the id of the targeted curvePoint
     * @return the selected curvePoint from database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public CurvePoint getById(Integer id) {
        log.info("Find curvePoint by id");
        return curvePointRepository.getOne(id);
    }


    /**
     * This method removes a curvePoint from database by calling delete method from CurvePointRepository
     * @param curvePoint the curvePoint to remove from database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(CurvePoint curvePoint) {
        log.info("Delete curvePoint");
        curvePointRepository.delete(curvePoint);
    }

    /**
     * This method is responsible for removing all curvePoint entries from database
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void clearDataBase() {
        log.info("Clear database");
        curvePointRepository.deleteAll();
    }
}
