package com.piotrtwardowski.triage.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PainLevel {

    S4(1, "Ból obezwładniający"),     //SUDDEN_DEBILITATING_PAIN
    S3(2, "Ból przeszywający"),     //STABBING_PAIN
    S2(3, "Ból nagły umiarkowany"),     //SUDDEN_MODERATE_PAIN
    S1(4, "Ból nagły nieznaczny"),     //SUDDEN_INSIGNIFICANT_PAIN
    NP(5, "0"),     //NO_PAIN
    C1(4, "Ból niewielki lub średni przewlekły"),     //MEDIUM_SEVERITY_CHRONIC_PAIN
    C2(3, "Ból i objawy wegetatywne"),     //PAIN_AND_AUTONOMIC_SIGNS
    C3(2, "Ból przewległy nagle zaostrzony");      //SUDDEN_EXACERBATION_OF_CHRONIC_PAIN

    private final Integer level;
    private final String name;
}
