package com.piotrtwardowski.triage.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConsciousnessLevel {

    D4(1, "Nie reaguje"),     //UNRESPONSIVE
    D3(2, "Reakcja na ból"),     //RESPONSE_TO_PAIN
    D2(3, "Reakcja na głos"),     //RESPONSE_TO_VOICE
    D1(4, "Zmieszanie"),     //DISORIENTED
    FA(5, "W pełnej gotowości"),     //FULLY_ALERT
    A1(4, "Pobudzony"),     //AGITATED
    A2(3, "Bardzo pobudzony"),     //VERY_AGITATED
    A3(2, "Agresywny");      //AGGRESSIVE

    private final Integer level;
    private final String name;
}
