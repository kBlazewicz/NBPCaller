package com.example.nbpcaller.controllers;

import com.example.nbpcaller.mappers.ExchangeRatesSeriesSimple;
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

    //In this case we may return same json as we fetched, but I decided to simplify it.
    @RequestMapping("api/exchange-rates/{currencyCode}")
    public ExchangeRatesSeriesSimple getExchangeRate(@PathVariable String currencyCode) {
        return exchangeService.getExchangeRate(currencyCode);
    }

}
