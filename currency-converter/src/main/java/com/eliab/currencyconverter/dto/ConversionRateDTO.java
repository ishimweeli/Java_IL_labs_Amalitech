package com.eliab.currencyconverter.dto;

import java.io.Serializable;

public class ConversionRateDTO implements Serializable {
    private String sourceCurrency;
    private String targetCurrency;
    private Double conversionRate;

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

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public String toString() {
        return "ConversionRateDTO{" +
                "sourceCurrency='" + sourceCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", conversionRate=" + conversionRate +
                '}';
    }
}
