package com.example.nbpcaller.services;

import com.example.nbpcaller.mappers.ExchangeRatesSeries;
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

    public ExchangeRatesSeries getExchangeRate(String currencyCode) {
        return getExchangeRatesSeries(currencyCode);
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
        ExchangeRatesSeries exchangeRatesSeries = responseEntity.getBody();
        return exchangeRatesSeries;
    }
}
