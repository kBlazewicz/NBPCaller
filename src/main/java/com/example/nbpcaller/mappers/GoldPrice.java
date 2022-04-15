package com.example.nbpcaller.mappers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// using lombok for code clarity
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoldPrice {
    @JsonProperty("cena")
    private float price;

    @JsonProperty("data")
    private LocalDate date;

    @Override
    public String toString() {
        return "{\"data\":\"" + date + ",\",\"cena\":" + price + "}";
    }
}
