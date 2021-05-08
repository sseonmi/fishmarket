package com.test.fishmarket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "business_times")
public class BusinessTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_times_id")
    @JsonIgnore
    private Stores stores;
    @Enumerated(EnumType.STRING)
    private Day day;
    @Column
    @JsonFormat(pattern = "HH:mm")
    private LocalTime open;
    @Column
    @JsonFormat(pattern = "HH:mm")
    private LocalTime close;

    @Setter
    private BusinessStatus businessStatus;
}