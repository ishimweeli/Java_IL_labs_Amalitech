package com.calculator.calculator.service;

import com.calculator.calculator.model.CalculatorModel;
import com.calculator.calculator.repository.CalculatorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    final CalculatorRepository calculatorRepository;

    public CalculatorServiceImpl(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    @Override
    public double add(double num1, double num2) {
        double result = num1 + num2;
        savePastCalculation("add", result);
        return result;
    }

    @Override
    public double subtract(double num1, double num2) {
        double result = num1 - num2;
        savePastCalculation("subtract", result);

        return result;
    }

    @Override
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        double result = num1 / num2;
        savePastCalculation("divide", result);
        return result;
    }

    @Override
    public double multiply(double num1, double num2) {
        double result = num1 * num2;
        savePastCalculation("multiply", result);
        return result;
    }

    @Override
    public double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
        }
        double result = Math.sqrt(num);
        savePastCalculation("squareRoot", result);
        return result;
    }

    @Override
    public double cosine(double angleInRadians) {
        double result = Math.cos(angleInRadians);
        savePastCalculation("cosine", result);
        return result;
    }

    @Override
    public double sine(double angleInRadians) {
        double result = Math.sin(angleInRadians);
        savePastCalculation("sine", result);
        return result;
    }

    @Override
    public List<CalculatorModel> getAllPastCalculations() {
        return calculatorRepository.findAll();
    }

    @Override
    public void savePastCalculation(String operation, double result) {
        CalculatorModel calculation = new CalculatorModel();
        calculation.setOperation(operation);
        calculation.setResult(result);
        calculation.setTimestamp(LocalDateTime.now());

        calculatorRepository.save(calculation);
    }

    @Override
    public void clearAllPastCalculations() {
        calculatorRepository.deleteAll();
    }
}
