package com.test.fishmarket.service;
import com.test.fishmarket.controller.StoreHolidaysController;
import com.test.fishmarket.dto.StoreHolidays;
import com.test.fishmarket.repository.StoreHolidaysRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreHolidaysService {
    private final StoreHolidaysRepository storesRepository;

    public StoreHolidaysService(StoreHolidaysRepository storesRepository) {
        this.storesRepository = storesRepository;
    }

    public List<StoreHolidays> setHolidays(StoreHolidaysController.StoreHolidayReq holidays) {
        List<StoreHolidays> holiday = new ArrayList<>();
        for (LocalDate h: holidays.getHolidays()) {
            holiday.add(StoreHolidays.builder().id(holidays.getId()).date(h).build());
        }
        return storesRepository.saveAll(holiday);
    }
}
