package com.test.fishmarket.controller;

import com.test.fishmarket.service.StoreHolidaysService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/stores/holidays")
public class StoreHolidaysController {
    @Autowired
    private StoreHolidaysService storeHolidaysService;

    @PostMapping
    public ResponseEntity<?> setStore(@RequestBody StoreHolidayReq holidays) throws Exception {
        return new ResponseEntity<>(storeHolidaysService.setHolidays(holidays), HttpStatus.OK);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StoreHolidayReq {
        private Long id;
        private List<LocalDate> holidays;
    }
}