package com.piotrtwardowski.triage.services;

import com.piotrtwardowski.triage.dtos.MedicalExaminationDTO;
import com.piotrtwardowski.triage.dtos.PatientDTO;
import com.piotrtwardowski.triage.entities.MedicalExaminationEntity;
import com.piotrtwardowski.triage.mappers.MedicalExaminationMapper;
import com.piotrtwardowski.triage.mappers.PatientMapper;
import com.piotrtwardowski.triage.repositories.MedicalExaminationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalExaminationService {

    private MedicalExaminationRepository medicalExaminationRepository;
    private MedicalExaminationMapper medicalExaminationMapper;
    private PatientMapper patientMapper;

    public List<MedicalExaminationDTO> getAllMedicalExaminationOfSinglePatient(PatientDTO patient) {
        List<MedicalExaminationEntity> medicalExaminationEntityList = medicalExaminationRepository
                .findAll()
                .stream()
                .filter(e -> patientMapper.toDTO(e.getPatient()).equals(patient))
                .collect(Collectors.toList());
        List<MedicalExaminationDTO> dtoList = medicalExaminationEntityList
                .stream()
                .map(e -> medicalExaminationMapper.toDTO(e))
                .collect(Collectors.toList());
        return dtoList;
    }

    public MedicalExaminationDTO getLatestMedicalExaminationOfSinglePatient(PatientDTO patient) {
        List<MedicalExaminationEntity> medicalExaminationEntityList = medicalExaminationRepository
                .findAll()
                .stream()
                .filter(e -> patientMapper.toDTO(e.getPatient()).equals(patient))
                .collect(Collectors.toList());
        List<MedicalExaminationDTO> dtoList = medicalExaminationEntityList
                .stream()
                .map(e -> medicalExaminationMapper.toDTO(e))
                .collect(Collectors.toList());
        return dtoList.get(0);
    }

    public void addNewMedicalExamination(MedicalExaminationDTO dto) {
        final MedicalExaminationEntity entity = medicalExaminationMapper.toEntity(dto);
        medicalExaminationRepository.save(entity);
    }
}
