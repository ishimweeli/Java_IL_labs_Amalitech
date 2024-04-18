package com.eliab.currencyconverter.services;

import com.eliab.currencyconverter.dto.ConversionDataDTO;

public interface CurrencyConversionService {
    ConversionDataDTO getConvertedValue(String sourceCurrency, String destinationCurrency, Double sourceCurrencyValue);
}
