package com.calculator.calculator.repository;

import com.calculator.calculator.model.CalculatorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepository extends JpaRepository<CalculatorModel, Long> {

}
