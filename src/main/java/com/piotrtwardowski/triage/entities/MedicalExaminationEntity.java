package com.piotrtwardowski.triage.entities;

import com.piotrtwardowski.triage.enums.ConsciousnessLevel;
import com.piotrtwardowski.triage.enums.PainLevel;
import com.piotrtwardowski.triage.enums.PriorityLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalExaminationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private PatientEntity patient;

    @Enumerated(EnumType.STRING)
    private ConsciousnessLevel consciousness;   //enum, 8 levels
    private Integer gcs;                        //Glasgow Coma Scale (3-15)
    private Integer oxygenSaturation;           //Oxygen saturation (85-100 %)
    private Integer glucoseLevel;               //Blood glucose level (40-200 mg%)
    private Float bodyTemperature;              //Body temperature (30.0 - 41.0 *C)
    private Integer capillaryRefill;            //Capillary refill time (1-3 s)
    @Enumerated(EnumType.STRING)
    private PainLevel painLevel;                //enum, 8 levels
    private Integer breathsNumberPerMinute;     //Breaths number per minute (9-60)
    private Integer pulse;                      //Pulse (50-180)
    private LocalDateTime medicalTestTime;      //Medical test time
    private Boolean hasPatientVisitedAnotherED; //Did patient visited other ED before coming to this one (TRUE is the only way to assign colour BLUE to patient)
    @Enumerated(EnumType.STRING)
    private PriorityLevel priorityLevel;        //enum, 5 levels

    public MedicalExaminationEntity(PatientEntity patient, ConsciousnessLevel consciousness, Integer gcs, Integer oxygenSaturation, Integer glucoseLevel, Float bodyTemperature, Integer capillaryRefill, PainLevel painLevel, Integer breathsNumberPerMinute, Integer pulse, LocalDateTime medicalTestTime, Boolean hasPatientVisitedAnotherED) {
        this.patient = patient;
        this.consciousness = consciousness;
        this.gcs = gcs;
        this.oxygenSaturation = oxygenSaturation;
        this.glucoseLevel = glucoseLevel;
        this.bodyTemperature = bodyTemperature;
        this.capillaryRefill = capillaryRefill;
        this.painLevel = painLevel;
        this.breathsNumberPerMinute = breathsNumberPerMinute;
        this.pulse = pulse;
        this.medicalTestTime = medicalTestTime;
        this.hasPatientVisitedAnotherED = hasPatientVisitedAnotherED;
    }
}
