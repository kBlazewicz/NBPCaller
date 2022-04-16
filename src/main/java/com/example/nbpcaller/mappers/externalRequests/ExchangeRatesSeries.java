package com.example.nbpcaller.mappers.externalRequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRatesSeries {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

    @Override
    public String toString() {
        return "{\"table\":\"" + table + "\",\"currency\":\"" + currency + "\",\"code\":\"" + code +
                "\",\"rates\":" + rates + "}";
    }
}
