package com.nnk.springboot.TU.domain;

import com.nnk.springboot.domain.CurvePoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CurvePointTest {

    @Test
    public void getCurvePoint() {
        CurvePoint curvePoint = CurvePoint.builder()
                .id(1).curveId(1).value(10.00).term(10.00).build();
        assertEquals(Integer.valueOf(1), curvePoint.getId());
        assertEquals(Integer.valueOf(1), curvePoint.getCurveId());
        assertEquals(Double.valueOf(10.00), curvePoint.getValue());
        assertEquals(Double.valueOf(10.00), curvePoint.getTerm());
    }

    @Test
    public void setCurvePoint() {
        CurvePoint curvePoint = CurvePoint.builder().build();
        curvePoint.setId(1);
        curvePoint.setCurveId(1);
        curvePoint.setValue(10.00);
        curvePoint.setTerm(10.00);
        assertEquals(Integer.valueOf(1), curvePoint.getId());
        assertEquals(Integer.valueOf(1), curvePoint.getCurveId());
        assertEquals(Double.valueOf(10.00), curvePoint.getValue());
        assertEquals(Double.valueOf(10.00), curvePoint.getTerm());
    }

    @Test
    public void testToString() {
        CurvePoint curvePoint = CurvePoint.builder()
                .id(1).curveId(1).value(10.00).term(10.00).build();
        assertNotNull(curvePoint.toString());
        CurvePoint curvePoint1 = CurvePoint.builder().build();
        //assertEquals("", curvePoint1.toString());
    }

}
