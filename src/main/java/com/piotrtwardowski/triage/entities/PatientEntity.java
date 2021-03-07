package com.piotrtwardowski.triage.entities;


import com.piotrtwardowski.triage.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String identificationNumber; //PESEL in Poland
    private LocalDateTime emergencyDepartmentArrivalTime;
    private Boolean hasMedicalInsurance;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Boolean hasPolishCitizenship;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<MedicalExaminationEntity> medicalExaminationEntitySet;

    public PatientEntity(String name, String surname, String identificationNumber, LocalDateTime emergencyDepartmentArrivalTime, Boolean hasMedicalInsurance, Integer age, Gender gender, Boolean hasPolishCitizenship, Set<MedicalExaminationEntity> medicalExaminationEntitySet) {
        this.name = name;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
        this.emergencyDepartmentArrivalTime = emergencyDepartmentArrivalTime;
        this.hasMedicalInsurance = hasMedicalInsurance;
        this.age = age;
        this.gender = gender;
        this.hasPolishCitizenship = hasPolishCitizenship;
        this.medicalExaminationEntitySet = medicalExaminationEntitySet;
    }
}
