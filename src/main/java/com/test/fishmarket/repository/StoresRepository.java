package com.test.fishmarket.repository;

import com.test.fishmarket.dto.Stores;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoresRepository extends JpaRepository<Stores, Long> {
    List<Stores> findAll(Sort sort);
}
