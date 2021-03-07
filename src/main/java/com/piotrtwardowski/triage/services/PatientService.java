package com.piotrtwardowski.triage.services;

import com.piotrtwardowski.triage.dtos.MedicalExaminationDTO;
import com.piotrtwardowski.triage.dtos.PatientDTO;
import com.piotrtwardowski.triage.entities.PatientEntity;
import com.piotrtwardowski.triage.mappers.PatientMapper;
import com.piotrtwardowski.triage.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final ClassificationService classificationService;

    public List<PatientDTO> getAllPatients() {
        final List<PatientEntity> allEntities = patientRepository.findAll();
        final List<PatientDTO> dtoList = allEntities.stream()
                .map(entity -> patientMapper.toDTO(entity))
                .sorted()
                .collect(Collectors.toList());
        return dtoList;
    }

    public PatientDTO getPatientByID(Long id) {
        final PatientEntity patientEntity = patientRepository.getOne(id);
        final PatientDTO patientDTO = patientMapper.toDTO(patientEntity);
        return patientDTO;
    }

    //TODO: returning set of examination so doctor can see whole history

    public MedicalExaminationDTO getLatestMedicalExaminationEntity(PatientDTO patient) { //TODO: change name
        List<MedicalExaminationDTO> chronologicalList = patient.getMedicalExaminationDTOSet().stream()
                .sorted((e1, e2) -> e1.getMedicalTestTime().compareTo(e2.getMedicalTestTime()))
                .collect(Collectors.toList());
        return chronologicalList.get(chronologicalList.size() - 1);
    }

    public void addNewPatient(PatientDTO dto) {
        classificationService.medicalExaminationClassification(dto.getLatestMedicalExamination());
        final PatientEntity entity = patientMapper.toEntity(dto);
        PatientEntity save = patientRepository.save(entity);
    }

    public void removePatient(PatientDTO dto) {
        patientRepository.deleteById(dto.getId());
    }
}
