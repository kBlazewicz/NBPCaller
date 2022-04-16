package com.example.nbpcaller.mappers.apiRequests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//class created to translate nbp json (cena -> price), (data -> date)
@AllArgsConstructor
@Getter
@Setter
public class GoldPriceModified {
    private double price;
    private LocalDate date;

    @Override
    public String toString() {
        return "{\"date\":\"" + date + ",\",\"price\":" + price + "}";
    }
}
