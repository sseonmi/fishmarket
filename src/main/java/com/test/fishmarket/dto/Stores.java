package com.test.fishmarket.dto;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stores")
public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String owner;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private int grade;
    @Column
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_times_id")
    private Set<BusinessTimes> businessTimes;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "store_holidays_id")
    private Set<StoreHolidays> storeHolidays;
}