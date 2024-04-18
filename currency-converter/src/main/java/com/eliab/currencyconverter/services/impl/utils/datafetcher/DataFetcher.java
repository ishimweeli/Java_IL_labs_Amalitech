package com.eliab.currencyconverter.services.impl.utils.datafetcher;

public interface DataFetcher {
    Double getConversionRate(String sourceCurrency, String destinationCurrency);
}
