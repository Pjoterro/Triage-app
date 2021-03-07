package com.piotrtwardowski.triage.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PriorityLevel {
    RED(1, "#FF2B2B"),        //level 1 - highest priority
    ORANGE(2, "#FFA52B"),     //level 2
    YELLOW(3, "#FFF92B"),     //level 3
    GREEN(4, "#7BFF2B"),      //level 4
    BLUE(5, "#2BB2FF");        //level 5 - lowest priority

    private final Integer level;
    private final String color;
}
