package com.eliab.currencyconverter.controllers;

import com.eliab.currencyconverter.dto.ConversionDataDTO;
import com.eliab.currencyconverter.dto.ConversionRateDTO;
import com.eliab.currencyconverter.services.CurrencyConversionService;
import com.eliab.currencyconverter.services.DataFetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
public class ConverterController {

    @Autowired
    CurrencyConversionService currencyConversionService;

    @Autowired
    DataFetcherService dataFetcherService;

    @PostMapping("/api/v1/currency/getConversionRate")
    @ResponseBody
    public ConversionRateDTO getConversionRate(@RequestParam String sourceCurrency,
                                               @RequestParam String destinationCurrency) {
        return dataFetcherService.getConversionRate(sourceCurrency, destinationCurrency);
    }

    @GetMapping("/api/v1/currency/getConvertedValue")
    @ResponseBody
    public ConversionDataDTO getConvertedValue(@RequestParam String sourceCurrency,
                                               @RequestParam String destinationCurrency,
                                               @RequestParam Double sourceCurrencyValue) {
        return currencyConversionService.getConvertedValue(sourceCurrency, destinationCurrency, sourceCurrencyValue);
    }
}
