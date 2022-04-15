package com.example.nbpcaller.controllers;

import com.example.nbpcaller.mappers.ExchangeRatesSeries;
import com.example.nbpcaller.services.ExchangeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }
    @RequestMapping("api/exchange-rates/{currencyCode}")
    public ExchangeRatesSeries getExchangeRate(@PathVariable String currencyCode) {
        return exchangeService.getExchangeRate(currencyCode);
    }

}
