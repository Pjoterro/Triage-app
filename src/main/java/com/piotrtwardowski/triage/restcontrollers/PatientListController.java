package com.piotrtwardowski.triage.restcontrollers;

import com.piotrtwardowski.triage.dtos.PatientDTO;
import com.piotrtwardowski.triage.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientListController {

    private final PatientService patientService;

    @GetMapping(value = "/patientListJSON")
    public List<PatientDTO> getAll() {
        return patientService.getAllPatients();
    }

}
