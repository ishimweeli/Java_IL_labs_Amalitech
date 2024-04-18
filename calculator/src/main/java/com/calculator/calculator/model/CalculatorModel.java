package com.calculator.calculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class CalculatorModel {
    @Id
    private String id;

    private String operation;
    private double operand1;
    private double operand2;
    private double result;
    private LocalDateTime timestamp;

    public CalculatorModel() {
        this.id = UUID.randomUUID().toString();
    }

}
