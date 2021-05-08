package com.test.fishmarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store_holidays")
public class StoreHolidays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_holidays_id")
    @JsonIgnore
    private Stores stores;
    @Column
    private LocalDate date;
}