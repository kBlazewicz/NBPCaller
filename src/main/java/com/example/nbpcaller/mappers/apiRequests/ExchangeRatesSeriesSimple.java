package com.example.nbpcaller.mappers.apiRequests;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ExchangeRatesSeriesSimple {
    private final String currency;
    private final List<RateSimple> rates = new ArrayList<>();

    public ExchangeRatesSeriesSimple(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "{\"currency\":\"" + currency + ",\"rates\":" + rates + "}";
    }

    public void addRate(RateSimple rateSimple) {
        rates.add(rateSimple);
    }
}
