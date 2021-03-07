package com.piotrtwardowski.triage.repositories;

import com.piotrtwardowski.triage.entities.MedicalExaminationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExaminationEntity, Long> {
}
