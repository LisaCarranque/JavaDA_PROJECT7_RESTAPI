package com.nnk.springboot.TU.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurveService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CurveServiceTest {

    @Mock
    CurvePointRepository curvePointRepository;

    @InjectMocks
    CurveService curveService;

    @Test
    public void findAll() {
        List<CurvePoint> curvePoint = curveService.findAll();
        verify(curvePointRepository, times(1)).findAll();
    }

    @Test
    public void add() {
        CurvePoint curvePoint = CurvePoint.builder().curveId(1).curveId(1).value(10.00)
                .term(10.00).build();
        curveService.add(curvePoint);
        verify(curvePointRepository, times(1)).save(curvePoint);
    }

    @Test
    public void update() {
        CurvePoint curvePoint = CurvePoint.builder().curveId(1).curveId(1).value(10.00)
                .term(10.00).build();
        curveService.update(curvePoint);
        verify(curvePointRepository, times(1)).save(curvePoint);
    }

    @Test
    public void getById() {
        curveService.getById(1);
        verify(curvePointRepository, times(1)).getOne(1);
    }

    @Test
    public void delete() {
        CurvePoint curvePoint = CurvePoint.builder().curveId(1).curveId(1).value(10.00)
                .term(10.00).build();
        curveService.delete(curvePoint);
        verify(curvePointRepository, times(1)).delete(curvePoint);
    }

}
