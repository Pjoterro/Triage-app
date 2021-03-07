package com.piotrtwardowski.triage.mappers;

import com.piotrtwardowski.triage.dtos.MedicalExaminationDTO;
import com.piotrtwardowski.triage.entities.MedicalExaminationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicalExaminationMapper {

    public MedicalExaminationDTO toDTO(MedicalExaminationEntity entity) {
        MedicalExaminationDTO dto = new MedicalExaminationDTO();

        dto.setId(entity.getId());
        dto.setConsciousness(entity.getConsciousness());
        dto.setGcs(entity.getGcs());
        dto.setOxygenSaturation(entity.getOxygenSaturation());
        dto.setGlucoseLevel(entity.getGlucoseLevel());
        dto.setBodyTemperature(entity.getBodyTemperature());
        dto.setCapillaryRefill(entity.getCapillaryRefill());
        dto.setPainLevel(entity.getPainLevel());
        dto.setBreathsNumberPerMinute(entity.getBreathsNumberPerMinute());
        dto.setPulse(entity.getPulse());
        dto.setMedicalTestTime(entity.getMedicalTestTime());
        dto.setHasPatientVisitedAnotherED(entity.getHasPatientVisitedAnotherED());
        dto.setPriorityLevel(entity.getPriorityLevel());

        return dto;
    }

    public MedicalExaminationEntity toEntity(MedicalExaminationDTO dto) {
        MedicalExaminationEntity entity = new MedicalExaminationEntity();

        entity.setId(dto.getId());
        entity.setConsciousness(dto.getConsciousness());
        entity.setGcs(dto.getGcs());
        entity.setOxygenSaturation(dto.getOxygenSaturation());
        entity.setGlucoseLevel(dto.getGlucoseLevel());
        entity.setBodyTemperature(dto.getBodyTemperature());
        entity.setCapillaryRefill(dto.getCapillaryRefill());
        entity.setPainLevel(dto.getPainLevel());
        entity.setBreathsNumberPerMinute(dto.getBreathsNumberPerMinute());
        entity.setPulse(dto.getPulse());
        entity.setMedicalTestTime(dto.getMedicalTestTime());
        entity.setHasPatientVisitedAnotherED(dto.getHasPatientVisitedAnotherED());
        entity.setPriorityLevel(dto.getPriorityLevel());

        return entity;
    }

}
