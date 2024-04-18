package com.eliab.currencyconverter.controllers;

import com.eliab.currencyconverter.services.CurrencyConversionService;
import com.eliab.currencyconverter.services.DataFetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@Controller
public class ConverterController {

    @Autowired
    CurrencyConversionService currencyConversionService;

    @Autowired
    DataFetcherService dataFetcherService;

    @PostMapping("/api/v1/currency/getConversionRate")
    @ResponseBody
    public Serializable getConversionRate(@RequestParam String sourceCurrency,
                                               @RequestParam String destinationCurrency) {
        try{
            return dataFetcherService.getConversionRate(sourceCurrency, destinationCurrency);
        }catch (Exception e){
            return "Enter valid currency.";
        }

    }

    @GetMapping("/api/v1/currency/getConvertedValue")
    @ResponseBody
    public Serializable getConvertedValue(@RequestParam String sourceCurrency,
                                               @RequestParam String destinationCurrency,
                                               @RequestParam Double sourceCurrencyValue) {
        try{
            return currencyConversionService.getConvertedValue(sourceCurrency, destinationCurrency, sourceCurrencyValue);
        }catch (Exception e){
            return "Enter valid currency.";
        }

    }
}
