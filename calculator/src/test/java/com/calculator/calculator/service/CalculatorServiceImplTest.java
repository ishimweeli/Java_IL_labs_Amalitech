package com.calculator.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceImplTest {

    @InjectMocks
    private CalculatorServiceImpl calculatorServiceImpl;

    @Test
    void testAdd() {

        double result = calculatorServiceImpl.add(5.0, 3.0);


        assertEquals(8.0, result);
    }

    @Test
    void testMultply() {

        double result = calculatorServiceImpl.multiply(5.0, 3.0);


        assertEquals(15.0, result);
    }
    @Test
    void testSubtract() {

        double result = calculatorServiceImpl.subtract(5.0, 3.0);


        assertEquals(2.0, result);
    }

    @Test
    void testDivide() {

        double result = calculatorServiceImpl.divide(10.0, 2.0);


        assertEquals(5.0, result);
    }
}
