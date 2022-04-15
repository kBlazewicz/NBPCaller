package com.example.nbpcaller.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.nbpcaller.services.GoldPriceService;

@RestController
public class GoldPriceController {

    private final GoldPriceService goldPriceService;

    public GoldPriceController(GoldPriceService goldPriceService) {
        this.goldPriceService = goldPriceService;
    }

    @RequestMapping("api/gold-price/average")
    public double getGoldPriceAvg() {
        return goldPriceService.getGoldPriceDaysAvg(14);
    }

}
