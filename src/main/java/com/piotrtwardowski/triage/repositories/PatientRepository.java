package com.piotrtwardowski.triage.repositories;

import com.piotrtwardowski.triage.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
