package com.example.nbpcaller.mappers.externalRequests;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {
    private String no;
    private LocalDate effectiveDate;
    private double mid;

    @Override
    public String toString() {
        return "{\"no\":\"" + no + "\",\"effectiveDate\":\"" + effectiveDate + "\",\"mid\":" + mid + "}";
    }
}
