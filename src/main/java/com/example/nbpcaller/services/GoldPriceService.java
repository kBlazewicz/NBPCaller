package com.example.nbpcaller.services;

import com.example.nbpcaller.mappers.GoldPrice;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GoldPriceService {
    private final RestTemplate restTemplate;

    public GoldPriceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public float getGoldPriceDaysAvg(int days) {
        return calculateAvgGoldPrice(days);
    }

    private float calculateAvgGoldPrice(int days) {
        List<GoldPrice> goldPrices = getGoldPrices(days);
        float result = 0;
        for (GoldPrice goldPrice : goldPrices) {
            result += goldPrice.getPrice();
        }
        return result / days;
    }

    private List<GoldPrice> getGoldPrices(int days) {
        ResponseEntity<List<GoldPrice>> responseEntity =
                restTemplate.exchange(
                        "http://api.nbp.pl/api/cenyzlota/last/" + days + "/?format=json",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<GoldPrice>>() {
                        }
                );
        List<GoldPrice> goldPrices = responseEntity.getBody();
        return goldPrices;
    }
}
