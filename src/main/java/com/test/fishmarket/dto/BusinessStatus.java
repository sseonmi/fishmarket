package com.test.fishmarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessStatus {
    OPEN, CLOSE, HOLIDAY;

    //private String description;
}