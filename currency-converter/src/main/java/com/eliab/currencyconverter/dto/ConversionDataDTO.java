package com.eliab.currencyconverter.dto;

import java.io.Serializable;


public class ConversionDataDTO implements Serializable {
    private String sourceCurrency;
    private String targetCurrency;
    private Double sourceCurrencyValue;
    private Double targetCurrencyValue;

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Double getSourceCurrencyValue() {
        return sourceCurrencyValue;
    }

    public void setSourceCurrencyValue(Double sourceCurrencyValue) {
        this.sourceCurrencyValue = sourceCurrencyValue;
    }

    public Double getTargetCurrencyValue() {
        return targetCurrencyValue;
    }

    public void setTargetCurrencyValue(Double targetCurrencyValue) {
        this.targetCurrencyValue = Math.round(targetCurrencyValue * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "ConversionDataDTO{" +
                "sourceCurrency='" + sourceCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", sourceCurrencyValue=" + sourceCurrencyValue +
                ", targetCurrencyValue=" + targetCurrencyValue +
                '}';
    }
}
