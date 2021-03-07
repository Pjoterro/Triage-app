package com.piotrtwardowski.triage.services;

import com.piotrtwardowski.triage.dtos.MedicalExaminationDTO;
import com.piotrtwardowski.triage.enums.ConsciousnessLevel;
import com.piotrtwardowski.triage.enums.PainLevel;
import com.piotrtwardowski.triage.enums.PriorityLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClassificationService {

    //TODO: maybe return bool so doctor/nurse can see if classification was successful?
    public void medicalExaminationClassification(MedicalExaminationDTO medicalExamination) {
        Set<PriorityLevel> priorityLevelSet = new HashSet<>();
        priorityLevelSet.add(consciousnessClassification(medicalExamination.getConsciousness()));
        priorityLevelSet.add(gcsClassification(medicalExamination.getGcs()));
        priorityLevelSet.add(oxygenSaturationClassification(medicalExamination.getOxygenSaturation()));
        priorityLevelSet.add(glucoseLevelClassification(medicalExamination.getGlucoseLevel()));
        priorityLevelSet.add(bodyTemperatureClassification(medicalExamination.getBodyTemperature()));
        priorityLevelSet.add(capillaryRefillClassification(medicalExamination.getCapillaryRefill()));
        priorityLevelSet.add(painLevelClassification(medicalExamination.getPainLevel()));
        priorityLevelSet.add(breathsNumberPerMinuteClassification(medicalExamination.getBreathsNumberPerMinute()));
        priorityLevelSet.add(pulseClassification(medicalExamination.getPulse()));
        medicalExamination.setPriorityLevel(priorityLevelSet.stream().min(Comparator.comparingInt(PriorityLevel::getLevel)).get());
        if (medicalExamination.getPriorityLevel().equals(PriorityLevel.GREEN) && medicalExamination.getHasPatientVisitedAnotherED()) {
            medicalExamination.setPriorityLevel(PriorityLevel.BLUE);
        }
    }

    private PriorityLevel consciousnessClassification (ConsciousnessLevel consciousness) {
        if (consciousness.getLevel() == 1) {
            return PriorityLevel.RED;
        } else if (consciousness.getLevel() == 2) {
            return PriorityLevel.ORANGE;
        } else if (consciousness.getLevel() == 3) {
            return PriorityLevel.YELLOW;
        } else if (consciousness.getLevel() == 4) {
            return PriorityLevel.GREEN;
        } else if (consciousness.getLevel() == 5) {
            return PriorityLevel.BLUE;
        } else {
            throw new IllegalArgumentException("Unable to set priority based on consciousness level.");
        }
    }

    private PriorityLevel gcsClassification (Integer gcs) {
        if (gcs < 10) {
            return PriorityLevel.RED;
        } else if (gcs < 12) {
            return PriorityLevel.ORANGE;
        } else if (gcs < 13) {
            return PriorityLevel.YELLOW;
        } else if (gcs <= 15) {
            return PriorityLevel.GREEN;
        } else {
            throw new IllegalArgumentException("Unable to set priority based on GCS.");
        }
    }

    private PriorityLevel oxygenSaturationClassification(Integer oxygenSaturation) {
        if (oxygenSaturation < 85) {
            return PriorityLevel.RED;
        } else if (oxygenSaturation < 89) {
            return PriorityLevel.ORANGE;
        } else if (oxygenSaturation < 94) {
            return PriorityLevel.YELLOW;
        } else if (oxygenSaturation <= 100) {
            return PriorityLevel.GREEN;
        } else {
            throw new IllegalArgumentException("Unable to set priority based on oxygen saturation.");
        }
    }

    private PriorityLevel glucoseLevelClassification(Integer glucoseLevel) {
        if (glucoseLevel < 40) {
            return PriorityLevel.RED;
        } else if (glucoseLevel < 49 || glucoseLevel > 200) {
            return PriorityLevel.ORANGE;
        } else if (glucoseLevel < 55 || glucoseLevel > 140) {
            return PriorityLevel.YELLOW;
        } else if (glucoseLevel <= 140 && glucoseLevel >= 55) {
            return PriorityLevel.GREEN;
        } else {
            throw new IllegalArgumentException("Unable to set priority based on glucose level.");
        }
    }

    private PriorityLevel bodyTemperatureClassification(Float bodyTemperature) {
        if (bodyTemperature <= 30.0 || bodyTemperature >= 41.0) {
            return PriorityLevel.RED;
        } else if (bodyTemperature <= 34.0 || bodyTemperature >= 40.0) {
            return PriorityLevel.ORANGE;
        } else if (bodyTemperature <= 35.0 || bodyTemperature >= 39.0) {
            return PriorityLevel.YELLOW;
        } else if (bodyTemperature > 35.0 && bodyTemperature < 39.0) {
            return PriorityLevel.GREEN;
        } else {
            throw new IllegalArgumentException("Unable to set priority based on body temperature.");
        }
    }

    private PriorityLevel capillaryRefillClassification(Integer capillaryRefill) {
        if (capillaryRefill > 3) {
            return PriorityLevel.RED;
        } else if (capillaryRefill > 2) {
            return PriorityLevel.ORANGE;
        } else if (capillaryRefill > 1) {
            return PriorityLevel.YELLOW;
        } else if (capillaryRefill == 1) {
            return PriorityLevel.GREEN;
        } else {
            throw new IllegalArgumentException("Unable to set priority based on capillary refill.");
        }
    }

    private PriorityLevel painLevelClassification(PainLevel painLevel) {
        if (painLevel.getLevel() == 1) {
            return PriorityLevel.RED;
        } else if (painLevel.getLevel() == 2) {
            return PriorityLevel.ORANGE;
        } else if (painLevel.getLevel() == 3) {
            return PriorityLevel.YELLOW;
        } else if (painLevel.getLevel() == 4) {
            return PriorityLevel.GREEN;
        } else if (painLevel.getLevel() == 5) {
            return PriorityLevel.BLUE;
        } else {
            throw new IllegalArgumentException("Unable to set priority based on consciousness level.");
        }
    }

    private PriorityLevel breathsNumberPerMinuteClassification(Integer breathsNumberPerMinute) {
        if (breathsNumberPerMinute < 9 || breathsNumberPerMinute > 30) {
            return PriorityLevel.RED;
        } else if (breathsNumberPerMinute < 12 || breathsNumberPerMinute > 26) {
            return PriorityLevel.ORANGE;
        } else if (breathsNumberPerMinute < 15 || breathsNumberPerMinute > 22) {
            return PriorityLevel.YELLOW;
        } else if (breathsNumberPerMinute >= 15 && breathsNumberPerMinute <= 22) {
            return PriorityLevel.GREEN;
        } else {
            throw new IllegalArgumentException("Unable to set priority based on breaths number per minute.");
        }
    }

    private PriorityLevel pulseClassification(Integer pulse) {
        if (pulse < 50) {
            return PriorityLevel.RED;
        } else if (pulse > 120) {
            return PriorityLevel.ORANGE;
        } else if (pulse < 60 || pulse > 100) {
            return PriorityLevel.YELLOW;
        } else if (pulse >= 60 && pulse <= 100) {
            return PriorityLevel.GREEN;
        } else {
            throw new IllegalArgumentException("Unable to set priority based on pulse.");
        }
    }
}
