package com.test.fishmarket.service;
import com.test.fishmarket.dto.*;
import com.test.fishmarket.repository.StoreHolidaysRepository;
import com.test.fishmarket.repository.StoresRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StoresService {
    private final StoresRepository storesRepository;
    private final StoreHolidaysRepository storeHolidaysRepository;

    public StoresService(StoresRepository storesRepository, StoreHolidaysRepository storeHolidaysRepository) {
        this.storesRepository = storesRepository;
        this.storeHolidaysRepository = storeHolidaysRepository;
    }

    /**
     * set Store
     * @param stores
     * @return
     */
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

    /**
     * get Store
     * @param id
     * @return
     */
    public StoreForRes getStore(Long id) {
        Stores stores = storesRepository.findById(id).get();
        List<StoreHolidays> storeHolidays = storeHolidaysRepository.findByDateBetween(LocalDate.now(), LocalDate.now().plusDays(1));

        List<BusinessTimes> businessTimes = new LinkedList<>();
        ArrayList<Integer> dayOfWeekList = new ArrayList();

        Calendar cal = Calendar.getInstance();
        dayOfWeekList.add(cal.get(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DATE, 1);
        dayOfWeekList.add(cal.get(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DATE, 1);
        dayOfWeekList.add(cal.get(Calendar.DAY_OF_WEEK));

        dayOfWeekList.stream()
                .forEach(dayOfWeek -> {
                    stores.getBusinessTimes().stream()
                            .filter(bt -> bt.getDay().getDayInt() == dayOfWeek)
                            .forEach(bt -> {
                                bt.setBusinessStatus(getBusinessStatusByTime(Optional.of(bt)));
                                businessTimes.add(bt);
                            });
                });

        StoreForRes res = StoreForRes.builder()
                .id(stores.getId())
                .name(stores.getName())
                .description(stores.getDescription())
                .level(stores.getLevel())
                .address(stores.getAddress())
                .phone(stores.getPhone())
                .businessDays(businessTimes)
                .build();

        return res;
    }

    /**
     * get Store list
     * @return List<StoreFroRes>
     */
    public List<StoresForRes> getStores() {
        List<Stores> stores = storesRepository.findAllWithBusinessTimesAndHolidays(Sort.by("level"));
        Calendar cal = Calendar.getInstance();
        Day dayOfWeek = Day.getNameFromValue(cal.get(Calendar.DAY_OF_WEEK));
        LocalDate today = LocalDate.now();

        List<StoresForRes>  filterList = stores.stream()
                .map(store -> {
                    Optional<BusinessTimes> bt = store.getBusinessTimes().stream().filter(d -> d.getDay() == dayOfWeek).findFirst();
                    Optional<StoreHolidays> sh = store.getStoreHolidays().stream().filter(d -> d.getDate().equals(today)).findFirst();
                    StoresForRes res = StoresForRes.builder()
                            .name(store.getName())
                            .description(store.getDescription())
                            .level(store.getLevel())
                            .businessStatus(getBusinessStatusByTimeAndHoliday(bt, sh))
                            .build();
                    return res;
                })
                .collect(Collectors.toList());

        return filterList;
    }

    public void removeStore(Long id) {
        storesRepository.deleteById(id);
    }


    /**
     * get BusinessStatus by time and holiday
     * @param businessTime
     * @param Holiday
     * @return BusinessStatus
     */
    private BusinessStatus getBusinessStatusByTimeAndHoliday(Optional<BusinessTimes> businessTime, Optional<StoreHolidays> Holiday) {
        LocalTime now = LocalTime.now();

        if(!Holiday.isEmpty()) return BusinessStatus.HOLIDAY;
        else if(businessTime.isEmpty()) return BusinessStatus.CLOSE;
        else if(now.isAfter(businessTime.get().getOpen())&&now.isBefore(businessTime.get().getClose())) return BusinessStatus.OPEN;
        else return BusinessStatus.CLOSE;

    }
    /**
     * get BusinessStatus by time
     * @param businessTime
     * @return BusinessStatus
     */
    private BusinessStatus getBusinessStatusByTime(Optional<BusinessTimes> businessTime) {
        return getBusinessStatusByTimeAndHoliday(businessTime, Optional.empty());
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StoresForRes {
        private String name;
        private String description;
        private int level;
        private BusinessStatus businessStatus;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StoreForRes {
        private Long id;
        private String name;
        private String description;
        private int level;
        private String address;
        private String phone;
        private List<BusinessTimes> businessDays;
    }

}
