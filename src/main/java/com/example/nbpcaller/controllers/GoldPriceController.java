package com.example.nbpcaller.controllers;

import com.example.nbpcaller.mappers.apiRequests.GoldPriceModified;
import com.example.nbpcaller.mappers.externalRequests.GoldPrice;
import com.example.nbpcaller.services.GoldPriceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoldPriceController {

    private final GoldPriceService goldPriceService;

    public GoldPriceController(GoldPriceService goldPriceService) {
        this.goldPriceService = goldPriceService;
    }

    @RequestMapping("api/gold-price/average")
    public List<GoldPriceModified> getGoldPriceAvg() {
        return goldPriceService.getGoldPriceDays(14);
    }

}
