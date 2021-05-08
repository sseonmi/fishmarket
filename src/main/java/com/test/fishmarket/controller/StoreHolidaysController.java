package com.test.fishmarket.controller;

import com.test.fishmarket.dto.StoreHolidays;
import com.test.fishmarket.dto.Stores;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/holiday")
public class StoreHolidaysController {

    @PostMapping
    public StoreHolidays setStore(@RequestBody Stores stores) {
        return null;
    }
}