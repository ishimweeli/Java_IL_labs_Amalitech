package com.calculator.calculator.controller;

import com.calculator.calculator.model.CalculatorModel;
import com.calculator.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public double add(@RequestParam double num1, @RequestParam double num2) {
        return calculatorService.add(num1, num2);
    }
    @PostMapping("/multiply")
    public double multiply(@RequestParam double num1, @RequestParam double num2) {
        return calculatorService.multiply(num1, num2);
    }
    @PostMapping("/subtract")
    public double subtract(@RequestParam double num1, @RequestParam double num2) {
        return calculatorService.subtract(num1, num2);
    }

    @PostMapping("/square-root")
    public double squareRoot(@RequestParam double num) {
        return calculatorService.squareRoot(num);
    }

    @PostMapping("/cosine")
    public double cosine(@RequestParam double angleInRadians) {
        return calculatorService.cosine(angleInRadians);
    }

    @PostMapping("/sine")
    public double sine(@RequestParam double angleInRadians) {
        return calculatorService.sine(angleInRadians);
    }

    @GetMapping("/past-calculations")
    public List<CalculatorModel> getAllPastCalculations() {
        return calculatorService.getAllPastCalculations();
    }

    @PostMapping("/save-calculation")
    public void savePastCalculation(@RequestParam String operation, @RequestParam double result) {
        calculatorService.savePastCalculation(operation, result);
    }

    @DeleteMapping("/clear-past-calculations")
    public void clearAllPastCalculations() {
        calculatorService.clearAllPastCalculations();
    }
}
