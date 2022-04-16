package com.example.nbpcaller.mappers.externalRequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoldPrice {
    @JsonProperty("cena")
    private double price;

    @JsonProperty("data")
    private LocalDate date;

    @Override
    public String toString() {
        return "{\"data\":\"" + date + ",\",\"cena\":" + price + "}";
    }
}
