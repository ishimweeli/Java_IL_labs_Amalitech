package com.calculator.calculator.service;

import com.calculator.calculator.model.CalculatorModel;

import java.util.List;

public interface CalculatorService {
    double add(double num1, double num2);

    double subtract(double num1, double num2);

    double divide(double num1, double num2);

    double multiply(double num1, double num2);

    double squareRoot(double num);

    double cosine(double angleInRadians);

    double sine(double angleInRadians);

    // New methods for saving and retrieving past calculations
    List<CalculatorModel> getAllPastCalculations();

    void savePastCalculation(String operation, double result);

    void clearAllPastCalculations();
}
