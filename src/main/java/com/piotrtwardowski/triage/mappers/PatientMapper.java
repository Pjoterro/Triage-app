package com.piotrtwardowski.triage.mappers;

import com.piotrtwardowski.triage.dtos.MedicalExaminationDTO;
import com.piotrtwardowski.triage.dtos.PatientDTO;
import com.piotrtwardowski.triage.entities.MedicalExaminationEntity;
import com.piotrtwardowski.triage.entities.PatientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PatientMapper {
    private final MedicalExaminationMapper medicalExaminationMapper;

    public PatientDTO toDTO(PatientEntity entity) {
        final PatientDTO dto = new PatientDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setIdentificationNumber(entity.getIdentificationNumber());
        dto.setEmergencyDepartmentArrivalTime(entity.getEmergencyDepartmentArrivalTime());
        dto.setHasMedicalInsurance(entity.getHasMedicalInsurance());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        dto.setHasPolishCitizenship(entity.getHasPolishCitizenship());
        final Set<MedicalExaminationDTO> medicalExaminationDTOSet = entity.getMedicalExaminationEntitySet()
                .stream()
                .map(e -> medicalExaminationMapper.toDTO(e))
                .collect(Collectors.toSet());
        dto.setMedicalExaminationDTOSet(medicalExaminationDTOSet);

        return dto;
    }

    public PatientEntity toEntity(PatientDTO dto) {
        final PatientEntity entity = new PatientEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setIdentificationNumber(dto.getIdentificationNumber());
        entity.setEmergencyDepartmentArrivalTime(dto.getEmergencyDepartmentArrivalTime());
        entity.setHasMedicalInsurance(dto.getHasMedicalInsurance());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity.setHasPolishCitizenship(dto.getHasPolishCitizenship());
        final Set<MedicalExaminationEntity> medicalExaminationEntitySet = dto.getMedicalExaminationDTOSet()
                .stream()
                .map(d -> {
                    MedicalExaminationEntity mee = medicalExaminationMapper.toEntity(d);
                    mee.setPatient(entity);
                    return mee;
                })
                .collect(Collectors.toSet());
        entity.setMedicalExaminationEntitySet(medicalExaminationEntitySet);

        return entity;
    }
}
