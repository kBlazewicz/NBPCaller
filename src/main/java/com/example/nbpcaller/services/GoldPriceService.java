package com.example.nbpcaller.services;

import com.example.nbpcaller.mappers.apiRequests.GoldPriceModified;
import com.example.nbpcaller.mappers.externalRequests.GoldPrice;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoldPriceService {
    private final RestTemplate restTemplate;

    public GoldPriceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GoldPriceModified> getGoldPriceDays(int days) {
        return modifyAttributes(getGoldPricesList(days));
    }

    private List<GoldPriceModified> modifyAttributes(List<GoldPrice> goldPricesList) {
        List<GoldPriceModified> goldPriceModifiedList = new ArrayList<>();
        for(GoldPrice goldPrice : goldPricesList){
            goldPriceModifiedList.add(new GoldPriceModified(goldPrice.getPrice(),goldPrice.getDate()));
        }
        return goldPriceModifiedList;
    }

    private List<GoldPrice> getGoldPricesList(int days) {
        ResponseEntity<List<GoldPrice>> responseEntity =
                restTemplate.exchange(
                        "http://api.nbp.pl/api/cenyzlota/last/" + days + "/?format=json",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<GoldPrice>>() {
                        }
                );
        return responseEntity.getBody();
    }
}
