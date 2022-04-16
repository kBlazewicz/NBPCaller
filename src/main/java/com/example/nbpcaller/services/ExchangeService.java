package com.example.nbpcaller.services;

import com.example.nbpcaller.mappers.apiRequests.ExchangeRatesSeriesSimple;
import com.example.nbpcaller.mappers.apiRequests.RateSimple;
import com.example.nbpcaller.mappers.externalRequests.ExchangeRatesSeries;
import com.example.nbpcaller.mappers.externalRequests.Rate;
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

    public ExchangeRatesSeriesSimple getExchangeRate(String currencyCode, int days) {
        return simplifyExchangeRatesSeries(getExchangeRatesSeries(currencyCode, days));
    }

    private ExchangeRatesSeries getExchangeRatesSeries(String currencyCode, int days) {
        ResponseEntity<ExchangeRatesSeries> responseEntity =
                restTemplate.exchange(
                        "http://api.nbp.pl/api/exchangerates/rates/a/" + currencyCode + "/last/" + days + "/?format=json",
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
