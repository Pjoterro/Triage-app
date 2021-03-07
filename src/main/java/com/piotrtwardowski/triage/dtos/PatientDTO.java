package com.piotrtwardowski.triage.dtos;

import com.piotrtwardowski.triage.enums.Gender;
import lombok.Data;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class PatientDTO implements Comparable<PatientDTO>{
    private Long id;
    private String name;
    private String surname;
    private String identificationNumber; //PESEL in Poland
    private LocalDateTime emergencyDepartmentArrivalTime;
    private Boolean hasMedicalInsurance;
    private Integer age;
    private Gender gender;
    private Boolean hasPolishCitizenship;
    private Set<MedicalExaminationDTO> medicalExaminationDTOSet;

    public MedicalExaminationDTO getLatestMedicalExamination() {
        List<MedicalExaminationDTO> chronologicalList = getMedicalExaminationDTOSet().stream()
                .sorted((e1, e2) -> e1.getMedicalTestTime().compareTo(e2.getMedicalTestTime()))
                .collect(Collectors.toList());
        return chronologicalList.get(chronologicalList.size() - 1);
    }

    @Override
    public int compareTo(PatientDTO o) {
        final MedicalExaminationDTO examination1 = this.getLatestMedicalExamination();
        final MedicalExaminationDTO examination2 = o.getLatestMedicalExamination();
        return new CompareToBuilder().append(examination1.getPriorityLevel().getLevel(), examination2.getPriorityLevel().getLevel())
                .append(examination1.getMedicalTestTime(), examination2.getMedicalTestTime())
                .build();
    }

    public PatientDTO(String name, String surname, String identificationNumber, LocalDateTime emergencyDepartmentArrivalTime, Boolean hasMedicalInsurance, Integer age, Gender gender, Boolean hasPolishCitizenship, Set<MedicalExaminationDTO> medicalExaminationDTOSet) {
        this.name = name;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
        this.emergencyDepartmentArrivalTime = emergencyDepartmentArrivalTime;
        this.hasMedicalInsurance = hasMedicalInsurance;
        this.age = age;
        this.gender = gender;
        this.hasPolishCitizenship = hasPolishCitizenship;
        this.medicalExaminationDTOSet = medicalExaminationDTOSet;
    }

    public PatientDTO() {
    }
}


