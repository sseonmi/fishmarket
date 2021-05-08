package com.test.fishmarket.service;
import com.test.fishmarket.dto.StoreHolidays;
import com.test.fishmarket.repository.StoreHolidaysRepository;
import org.springframework.stereotype.Service;

@Service
public class StoreHolidaysService {
    private final StoreHolidaysRepository storesRepository;

    public StoreHolidaysService(StoreHolidaysRepository storesRepository) {
        this.storesRepository = storesRepository;
    }

    public StoreHolidays setStore(StoreHolidays stores) {
        StoreHolidays store = StoreHolidays.builder()
                .build();
        return storesRepository.save(store);
    }
}
