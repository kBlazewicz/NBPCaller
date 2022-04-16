package com.example.nbpcaller.services;

import com.example.nbpcaller.mappers.ExchangeRatesSeries;
import com.example.nbpcaller.mappers.ExchangeRatesSeriesSimple;
import com.example.nbpcaller.mappers.Rate;
import com.example.nbpcaller.mappers.RateSimple;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeService {

    private final RestTemplate restTemplate;

    public ExchangeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ExchangeRatesSeriesSimple getExchangeRate(String currencyCode) {
        return simplifyExchangeRatesSeries(getExchangeRatesSeries(currencyCode));
    }

    private ExchangeRatesSeries getExchangeRatesSeries(String currencyCode) {
        ResponseEntity<ExchangeRatesSeries> responseEntity =
                restTemplate.exchange(
                        "http://api.nbp.pl/api/exchangerates/rates/a/" + currencyCode + "/last/5/?format=json",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ExchangeRatesSeries>() {
                        }
                );
        return responseEntity.getBody();
    }

    private ExchangeRatesSeriesSimple simplifyExchangeRatesSeries(ExchangeRatesSeries exchangeRatesSeries) {
        ExchangeRatesSeriesSimple simplifiedSeries = new ExchangeRatesSeriesSimple(exchangeRatesSeries.getCurrency());
        for (Rate rate : exchangeRatesSeries.getRates()) {
            simplifiedSeries.addRate(new RateSimple(rate.getEffectiveDate(), rate.getMid()));
        }
        return simplifiedSeries;
    }
}
