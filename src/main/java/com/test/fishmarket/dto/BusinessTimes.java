package com.test.fishmarket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "business_times")
public class BusinessTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stores_id")
    private Stores stores;
    @Enumerated(EnumType.STRING)
    private Day day;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "HH:mm")
    private Date open;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "HH:mm")
    private Date close;
}