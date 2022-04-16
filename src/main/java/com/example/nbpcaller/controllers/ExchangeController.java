package com.example.nbpcaller.controllers;

import com.example.nbpcaller.mappers.apiRequests.ExchangeRatesSeriesSimple;
import com.example.nbpcaller.services.ExchangeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExchangeController {
    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    //In this case we may return same json the same as we fetched, but I decided to simplify it.
    @RequestMapping("api/exchange-rates/{currencyCode}")
    public ExchangeRatesSeriesSimple getExchangeRate(@PathVariable String currencyCode) {
        return exchangeService.getExchangeRate(currencyCode,5);
    }

}
