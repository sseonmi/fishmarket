package com.test.fishmarket.service;
import com.test.fishmarket.dto.Stores;
import com.test.fishmarket.repository.StoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StoresService {
    private final StoresRepository storesRepository;

    public StoresService(StoresRepository storesRepository) {
        this.storesRepository = storesRepository;
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
                .grade(1)
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
        return storesRepository.findAll();
    }
}
