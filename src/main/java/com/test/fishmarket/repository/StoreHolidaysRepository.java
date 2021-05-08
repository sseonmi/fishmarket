package com.test.fishmarket.repository;

import com.test.fishmarket.dto.StoreHolidays;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreHolidaysRepository extends JpaRepository<StoreHolidays, Long> {
    List<StoreHolidays> findAll(Sort sort);
}
