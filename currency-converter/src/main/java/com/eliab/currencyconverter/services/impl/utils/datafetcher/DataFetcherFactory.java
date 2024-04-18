package com.eliab.currencyconverter.services.impl.utils.datafetcher;

import com.eliab.currencyconverter.entities.enums.DATAFETCHER_TYPE;

public class DataFetcherFactory {
    private static DataFetcher dataFetcher;
    private static boolean isInitialized;

    private static void initialize(DATAFETCHER_TYPE datafetcherType) {
        isInitialized = true;
        switch (datafetcherType) {
            case ECB:
                dataFetcher = new ECBDataFetcher();
                break;
            default:
                dataFetcher = new ECBDataFetcher();
        }
    }

    public static DataFetcher getDataFetcher(DATAFETCHER_TYPE datafetcherType) {
        if (!isInitialized) {
            initialize(datafetcherType);
        }
        return dataFetcher;
    }
}
