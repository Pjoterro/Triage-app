package com.piotrtwardowski.triage.services;

import com.piotrtwardowski.triage.dtos.MedicalExaminationDTO;
import com.piotrtwardowski.triage.dtos.PatientDTO;
import com.piotrtwardowski.triage.enums.ConsciousnessLevel;
import com.piotrtwardowski.triage.enums.Gender;
import com.piotrtwardowski.triage.enums.PainLevel;
import com.piotrtwardowski.triage.mappers.MedicalExaminationMapper;
import com.piotrtwardowski.triage.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Log4j2
public class InitialDataService implements CommandLineRunner {

    private final PatientRepository patientRepository;
    private final ClassificationService classificationService;
    private final MedicalExaminationMapper medicalExaminationMapper;
    private final PatientService patientService;

    @Override
    @Transactional
    public void run(String... args) {
        log.info("Adding initial patient list");
        fillSamplePatients();
    }

    void fillSamplePatients() {
        PatientDTO patientGreen = new PatientDTO(
                "Ziemowit"
                , "Zielony"
                , "87031800000"
                , LocalDateTime.now().minusMinutes(15)
                , true
                , 28
                , Gender.MALE
                , true
                , new HashSet<>()
                );
        MedicalExaminationDTO greenExamination = new MedicalExaminationDTO(
                ConsciousnessLevel.FA
                , 15
                , 100
                , 120
                , 36.6F
                , 1
                , PainLevel.NP
                , 20
                , 80
                , LocalDateTime.now().minusMinutes(10)
                , false
        );
        Set<MedicalExaminationDTO> greenExamSet = new HashSet<>();
        greenExamSet.add(greenExamination);
        patientGreen.setMedicalExaminationDTOSet(greenExamSet);
        patientService.addNewPatient(patientGreen);

        PatientDTO patientYellow = new PatientDTO(
                "Żyrosława"
                , "Żółta"
                , "73020200000"
                , LocalDateTime.now().minusMinutes(5)
                , true
                , 30
                , Gender.FEMALE
                , false
                , new HashSet<>()
        );
        MedicalExaminationDTO yellowExamination = new MedicalExaminationDTO(
                ConsciousnessLevel.D1
                , 12
                , 92
                , 52
                , 34.9F
                , 2
                , PainLevel.S1
                , 15
                , 55
                , LocalDateTime.now().minusMinutes(3)
                , false
        );
        Set<MedicalExaminationDTO> yellowExamSet = new HashSet<>();
        yellowExamSet.add(yellowExamination);
        patientYellow.setMedicalExaminationDTOSet(yellowExamSet);
        patientService.addNewPatient(patientYellow);

        PatientDTO patientOrange = new PatientDTO(
                "Pola"
                , "Pomarańczowa"
                , "99123100000"
                , LocalDateTime.now().minusMinutes(3)
                , false
                , 19
                , Gender.FEMALE
                , true
                , new HashSet<>()
        );
        MedicalExaminationDTO orangeExamination = new MedicalExaminationDTO(
                ConsciousnessLevel.A2
                , 11
                , 86
                , 45
                , 32.6F
                , 3
                , PainLevel.C2
                , 29
                , 130
                , LocalDateTime.now().minusMinutes(2)
                , false
        );
        Set<MedicalExaminationDTO> orangeExamSet = new HashSet<>();
        orangeExamSet.add(orangeExamination);
        patientOrange.setMedicalExaminationDTOSet(orangeExamSet);
        patientService.addNewPatient(patientOrange);

        PatientDTO patientRed = new PatientDTO(
                "Czesław"
                , "Czerwony"
                , "99123100000"
                , LocalDateTime.now().minusMinutes(2)
                , true
                , 78
                , Gender.MALE
                , true
                , new HashSet<>()
        );
        MedicalExaminationDTO redExamination = new MedicalExaminationDTO(
                ConsciousnessLevel.D4
                , 7
                , 80
                , 30
                , 27.0F
                , 5
                , PainLevel.S4
                , 70
                , 130
                , LocalDateTime.now().minusMinutes(2)
                , false
        );
        Set<MedicalExaminationDTO> redExamSet = new HashSet<>();
        redExamSet.add(redExamination);
        patientRed.setMedicalExaminationDTOSet(redExamSet);
        patientService.addNewPatient(patientRed);

        PatientDTO patientBlue = new PatientDTO(
                "Niegosław"
                , "Niebieski"
                , "99123100000"
                , LocalDateTime.now().minusMinutes(30)
                , true
                , 17
                , Gender.MALE
                , true
                , new HashSet<>()
        );
        MedicalExaminationDTO blueExamination = new MedicalExaminationDTO(
                ConsciousnessLevel.FA
                , 15
                , 100
                , 70
                , 36.6F
                , 1
                , PainLevel.NP
                , 15
                , 70
                , LocalDateTime.now().minusMinutes(25)
                , true
        );
        Set<MedicalExaminationDTO> blueExamSet = new HashSet<>();
        blueExamSet.add(blueExamination);
        patientBlue.setMedicalExaminationDTOSet(blueExamSet);
        patientService.addNewPatient(patientBlue);

    }
}
