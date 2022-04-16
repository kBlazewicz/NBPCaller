package com.example.nbpcaller.mappers.apiRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class RateSimple {
    private LocalDate date;
    private double price;

    @Override
    public String toString() {
        return "{\",\"date\":\"" + date + "\",\"price\":" + price + "}";
    }
}
