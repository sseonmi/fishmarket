package com.test.fishmarket.service;
import com.test.fishmarket.dto.BusinessStatus;
import com.test.fishmarket.dto.BusinessTimes;
import com.test.fishmarket.dto.StoreHolidays;
import com.test.fishmarket.dto.Stores;
import com.test.fishmarket.repository.StoreHolidaysRepository;
import com.test.fishmarket.repository.StoresRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoresService {
    private final StoresRepository storesRepository;
    private final StoreHolidaysRepository storeHolidaysRepository;

    public StoresService(StoresRepository storesRepository, StoreHolidaysRepository storeHolidaysRepository) {
        this.storesRepository = storesRepository;
        this.storeHolidaysRepository = storeHolidaysRepository;
    }
    public Stores setStore(Stores stores) {
        stores.getBusinessTimes().stream()
                .forEach(businessTime -> {
                    if(businessTime.getOpen().equals(businessTime.getClose())) System.out.println("시작, 종료 시간이 같을수 없음");
                });

        Stores store = Stores.builder()
                .name(stores.getName())
                .address(stores.getAddress())
                .owner(stores.getOwner())
                .level(stores.getLevel())
                .phone(stores.getPhone())
                .businessTimes(stores.getBusinessTimes())
                .build();
        return storesRepository.save(store);
    }

    public Stores getStore(Long id) {
        Optional<Stores> store = storesRepository.findById(id);

        return store.get();
    }

    public List<Stores> getStores() {
        List<Stores> stores = storesRepository.findAll(Sort.by("level"));
        List<StoreHolidays> storeHolidays = storeHolidaysRepository.findAll();

        return stores;
    }
}
