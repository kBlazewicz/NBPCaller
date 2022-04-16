package com.example.nbpcaller.mappers;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ExchangeRatesSeriesSimple {
    private final String currency;
    private final List<RateSimple> rateSimpleList = new ArrayList<>();

    public ExchangeRatesSeriesSimple(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "{\"currency\":\"" + currency + ",\"rates\":" + rateSimpleList + "}";
    }

    public void addRate(RateSimple rateSimple) {
        rateSimpleList.add(rateSimple);
    }
}
