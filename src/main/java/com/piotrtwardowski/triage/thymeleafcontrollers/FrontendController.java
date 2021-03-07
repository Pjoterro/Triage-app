package com.piotrtwardowski.triage.thymeleafcontrollers;

import com.piotrtwardowski.triage.dtos.MedicalExaminationDTO;
import com.piotrtwardowski.triage.dtos.PatientDTO;
import com.piotrtwardowski.triage.enums.ConsciousnessLevel;
import com.piotrtwardowski.triage.enums.Gender;
import com.piotrtwardowski.triage.enums.PainLevel;
import com.piotrtwardowski.triage.mappers.MedicalExaminationMapper;
import com.piotrtwardowski.triage.services.ClassificationService;
import com.piotrtwardowski.triage.services.HelloWorldService;
import com.piotrtwardowski.triage.services.MedicalExaminationService;
import com.piotrtwardowski.triage.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class FrontendController {
    private final PatientService patientService;
    private final HelloWorldService helloWorldService;
    private final MedicalExaminationService medicalExaminationService;
    private final ClassificationService classificationService;
    private final MedicalExaminationMapper medicalExaminationMapper;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("powitanie", helloWorldService.fetchHelloMessage());
        return "index";
    }

    @GetMapping("/patients")
    public String patientList(Model model) {
        final List<PatientDTO> patientList = patientService.getAllPatients();
        model.addAttribute("patients", patientList);
        return "patients";
    }

    @GetMapping("/patient/{id}")
    public String patient(Model model, @PathVariable Long id) {
        PatientDTO dto = patientService.getPatientByID(id);
        model.addAttribute("patient", dto);
        MedicalExaminationDTO exam = patientService.getLatestMedicalExaminationEntity(patientService.getPatientByID(id));
        model.addAttribute("exam", exam);
        return "patient";
    }

    @GetMapping("/addPatient")
    public String addPatient(Model model) {
        PatientDTO patient = new PatientDTO();
        MedicalExaminationDTO exam = new MedicalExaminationDTO();
        model.addAttribute("patientDTO", patient);
        model.addAttribute("gender", Gender.values());
        model.addAttribute("exam", exam);
        model.addAttribute("consciousness", ConsciousnessLevel.values());
        model.addAttribute("painLevel", PainLevel.values());

        return "addPatient";
    }

    @PostMapping("/addPatient")
    public String postAddPatient(PatientDTO dto, MedicalExaminationDTO exam) {
        dto.setEmergencyDepartmentArrivalTime(LocalDateTime.now());
        exam.setMedicalTestTime(LocalDateTime.now());
        Set<MedicalExaminationDTO> examSet = new HashSet<>();
        examSet.add(exam);
        dto.setMedicalExaminationDTOSet(examSet);
        //classificationService.medicalExaminationClassification(medicalExaminationMapper.toEntity(exam));
        //dto.getMedicalExaminationDTOSet().add(exam);
        patientService.addNewPatient(dto);
        return "redirect:/patients";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(Model model, @PathVariable Long id) {
        PatientDTO dto = patientService.getPatientByID(id);
        patientService.removePatient(dto);
        return "redirect:/patients";
    }
}
