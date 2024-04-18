package com.eliab.currencyconverter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "ELIAB Currency Converter Service is up and running.\n" +
                "Supported APIs:\n" +
                "/api/v1/currency/getConversionRate?sourceCurrency={}&destinationCurrency={}\n" +
                "/api/v1/currency/getConvertedValue?sourceCurrency={}&destinationCurrency={}&sourceCurrencyValue={}";
    }
}
