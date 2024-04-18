package com.eliab.currencyconverter.services.impl;

import com.eliab.currencyconverter.dto.ConversionDataDTO;
import com.eliab.currencyconverter.dto.ConversionRateDTO;
import com.eliab.currencyconverter.entities.enums.CURRENCY_TYPE;
import com.eliab.currencyconverter.services.CurrencyConversionService;
import com.eliab.currencyconverter.services.DataFetcherService;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    @Autowired
    DataFetcherService dataFetcherService;

    private boolean isValidCurrencyType(String currencyType) {
        return EnumUtils.isValidEnum(CURRENCY_TYPE.class, currencyType);
    }

    public ConversionDataDTO getConvertedValue(String fromCurrency,
                                               String toCurrency,
                                               Double fromCurrencyValue) throws RuntimeException {
        if (!isValidCurrencyType(fromCurrency) || !isValidCurrencyType(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency type passed.");
        }
        ConversionDataDTO conversionDataDTO = new ConversionDataDTO();
        conversionDataDTO.setSourceCurrency(fromCurrency);
        conversionDataDTO.setTargetCurrency(toCurrency);
        conversionDataDTO.setSourceCurrencyValue(fromCurrencyValue);
        ConversionRateDTO conversionRateDTO = dataFetcherService.getConversionRate(fromCurrency, toCurrency);
        if (conversionRateDTO == null) {
            throw new RuntimeException("Failed to fetch conversion rate.");
        }
        Double targetValue = fromCurrencyValue * conversionRateDTO.getConversionRate();
        conversionDataDTO.setTargetCurrencyValue(targetValue);
        return conversionDataDTO;
    }
}
