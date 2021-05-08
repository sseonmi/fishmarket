package com.test.fishmarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Day {
    Monday(2),
    Tuesday(3),
    Wednesday(4),
    Thursday(5),
    Friday(6),
    Saturday(7),
    Sunday(1);

    private int dayInt;

    public static Day getNameFromValue(int code){
        for(Day e : Day.values()){
            if(e.dayInt == code) return e;
        }
        return null;
    }

}
