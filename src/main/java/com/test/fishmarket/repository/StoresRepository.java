package com.test.fishmarket.repository;

import com.test.fishmarket.dto.Day;
import com.test.fishmarket.dto.Stores;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoresRepository extends JpaRepository<Stores, Long> {
    @Query(value = "select DISTINCT c from Stores c left join fetch c.businessTimes left join fetch c.storeHolidays")
    List<Stores> findAllByBusinessTimesIn(Sort sort);

}
