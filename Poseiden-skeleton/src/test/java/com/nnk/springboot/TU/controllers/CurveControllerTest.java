package com.nnk.springboot.TU.controllers;

import com.nnk.springboot.controllers.CurveController;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurveService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CurveControllerTest {

    @Mock
    CurveService curveService;

    @InjectMocks
    CurveController curveController;

    @Spy
    BindingResult bindingResult;

    @Spy
    Model model;

    @Test
    public void home() {
        curveController.home(model);
        verify(curveService, times(1)).findAll();
    }

    @Test
    public void validate() {
        CurvePoint curvePoint = CurvePoint.builder().curveId(1).curveId(1).value(10.00)
                .term(10.00).build();
        curveController.validate(curvePoint, bindingResult, model);
        verify(curveService, times(1)).add(curvePoint);
    }

    @Test
    public void showUpdateForm() {
        BidList bidList = BidList.builder().bidListId(1).bidQuantity(10.00).build();
        curveController.showUpdateForm(1, model);
        verify(curveService, times(1)).getById(1);
    }

    @Test
    public void updateBid() {
        CurvePoint curvePoint = CurvePoint.builder().curveId(1).curveId(1).value(10.00)
                .term(10.00).build();
        curveController.updateBid(1, curvePoint, bindingResult, model);
        verify(curveService, times(1)).update(curvePoint);
        verify(curveService, times(1)).findAll();
    }

    @Test
    public void deleteBid() {
        CurvePoint curvePoint = CurvePoint.builder().curveId(1).curveId(1).value(10.00)
                .term(10.00).build();
        when(curveService.getById(1)).thenReturn(curvePoint);
        curveController.deleteBid(1, model);

        verify(curveService, times(1)).getById(1);
        verify(curveService, times(1)).delete(curvePoint);
    }


}
