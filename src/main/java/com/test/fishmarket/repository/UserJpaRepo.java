package com.test.fishmarket.repository;

import com.test.fishmarket.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepo extends JpaRepository<User, Long> {}