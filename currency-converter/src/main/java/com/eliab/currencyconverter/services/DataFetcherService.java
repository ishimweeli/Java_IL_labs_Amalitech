package com.eliab.currencyconverter.services;


import com.eliab.currencyconverter.dto.ConversionRateDTO;

public interface DataFetcherService {
    ConversionRateDTO getConversionRate(String sourceCurrency, String destinationCurrency);
}
