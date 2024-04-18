package com.eliab.currencyconverter.services.impl;

import com.eliab.currencyconverter.dto.ConversionRateDTO;
import com.eliab.currencyconverter.entities.enums.DATAFETCHER_TYPE;
import com.eliab.currencyconverter.services.DataFetcherService;
import com.eliab.currencyconverter.services.impl.utils.datafetcher.DataFetcher;
import com.eliab.currencyconverter.services.impl.utils.datafetcher.DataFetcherFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class DataFetcherServiceImpl implements DataFetcherService {
    DATAFETCHER_TYPE datafetcherType = DATAFETCHER_TYPE.ECB;
    DataFetcher dataFetcher;

    DataFetcherServiceImpl() {
        dataFetcher = DataFetcherFactory.getDataFetcher(datafetcherType);
    }

    @Cacheable("conversion_rate")
    public ConversionRateDTO getConversionRate(String fromCurrency, String toCurrency) {
        Double conversionRate = dataFetcher.getConversionRate(fromCurrency, toCurrency);
        ConversionRateDTO conversionRateDTO = new ConversionRateDTO();
        conversionRateDTO.setSourceCurrency(fromCurrency);
        conversionRateDTO.setTargetCurrency(toCurrency);
        conversionRateDTO.setConversionRate(conversionRate);
        return conversionRateDTO;
    }
}
