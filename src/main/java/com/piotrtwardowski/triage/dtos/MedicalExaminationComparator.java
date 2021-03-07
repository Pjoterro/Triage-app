package com.piotrtwardowski.triage.dtos;

import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Comparator;

public class MedicalExaminationComparator implements Comparator<MedicalExaminationDTO> {

    @Override
    public int compare(MedicalExaminationDTO o1, MedicalExaminationDTO o2) {
        return new CompareToBuilder().append(o1.getPriorityLevel().getLevel(), o2.getPriorityLevel().getLevel())
                .append(o1.getMedicalTestTime(), o2.getMedicalTestTime())
                .build(); // w razie czego zamienic o1 i o2 miejscami


//        if (o1.getPriorityLevel().getLevel() < o2.getPriorityLevel().getLevel()) {
//            return 1;
//        } else if (o1.getPriorityLevel().getLevel() > o2.getPriorityLevel().getLevel()) {
//            return -1;
//        } else {
//            if (o1.getMedicalTestTime().compareTo(o2.getMedicalTestTime()) > 0) {
//                return -1;
//            } else if (o1.getMedicalTestTime().compareTo(o2.getMedicalTestTime()) < 0) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
    }

    //TODO:
    // - implementacja PriorityQueue
    // - zapisywanie nowego pacjenta z triagem - program sie wysypuje
    // - wyciaganie koloru triagu aby ustawic odpowiedni kolor background
    // -
}
