package com.nnk.springboot.IT.services;

import com.nnk.springboot.Application;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurveService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {Application.class, CurveService.class})
@EnableJpaRepositories(basePackageClasses = {CurvePointRepository.class})
@EntityScan(basePackageClasses = {CurvePoint.class})
@ContextConfiguration
@ActiveProfiles("test")
public class CurveServiceIT {

    @Autowired
    private CurveService curveService;

    @Autowired
    private CurvePointRepository curvePointRepository;

    @AfterEach
    public void deleteAll() {
        curveService.clearDataBase();
    }

    @Test
    public void save() {
        CurvePoint curvePoint = CurvePoint.builder().curveId(1).value(10.00).term(10.00).build();
        CurvePoint curvePointSaved = curveService.add(curvePoint);
        assertNotNull(curvePointSaved);
        assertEquals(Integer.valueOf(1), curvePointSaved.getCurveId());
    }

    @Test
    public void list() {
        List<CurvePoint> curvePoints = curveService.findAll();
        assertNotNull(curvePoints);
    }

    @Test
    public void delete() {
        List<CurvePoint> curvePoints = curveService.findAll();
        assertNotNull(curvePoints);
        int size = curvePoints.size();
        CurvePoint curvePoint = curveService.getById(200);
        curveService.delete(curvePoint);
        List<CurvePoint> curvePointsAfterDelete = curveService.findAll();
        assertEquals(size - 1, curvePointsAfterDelete.size());
    }

}