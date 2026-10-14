package medical_action_tracking;

import patient_intake.Patient;

public class EmergencyWaitingRoom {
    private LinkedQueue<Patient> level1;
    private LinkedQueue<Patient> level2;
    private LinkedQueue<Patient> level3;
    private LinkedQueue<Patient> level4;
    public static final int LANECAPACITY = 5; //for the bounded waiting lanes extension

    public EmergencyWaitingRoom() {
        // TODO: Create one empty FIFO queue for each triage level.
        level1 = new LinkedQueue<Patient>();
        level2 = new LinkedQueue<Patient>();
        level3 = new LinkedQueue<Patient>();
        level4 = new LinkedQueue<Patient>();
    }

    /**
     * Add a patient to the FIFO lane matching their triage level.
     *
     * @return true if added; false for null patients or levels outside 1-4
     */
    public boolean addPatient(Patient patient) {
        // TODO: Validate the patient and place them in the matching lane.
        if(patient == null){
            return false;
        }

        if (patient.getTriageLevel() == 1) {
            if (level1.size() >= LANECAPACITY) return false;
            level1.enqueue(patient);
            return true;
        } else if (patient.getTriageLevel() == 2) {
            if (level2.size() >= LANECAPACITY) return false;
            level2.enqueue(patient);
            return true;
        } else if (patient.getTriageLevel() == 3) {
            if (level3.size() >= LANECAPACITY) return false;
            level3.enqueue(patient);
            return true;
        } else if (patient.getTriageLevel() == 4) {
            if (level4.size() >= LANECAPACITY) return false;
            level4.enqueue(patient);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove the next patient, checking triage level 1 before level 2, and so on.
     */
    public Patient nextPatient() {
        // TODO: Dequeue from the first non-empty lane, or return null if all are empty.
        if(level1.peekFront() != null){
            level1.peekFront().setCurrentStage("Treatment");
            return level1.dequeue();
        } else if(level2.peekFront() != null){
            level2.peekFront().setCurrentStage("Treatment");
            return level2.dequeue();
        } else if(level3.peekFront() != null){
            level3.peekFront().setCurrentStage("Treatment");
            return level3.dequeue();
        } else if(level4.peekFront() != null){
            level4.peekFront().setCurrentStage("Treatment");
            return level4.dequeue();
        } else{
            return null;
        }
    }

    public boolean isEmpty() {
        // TODO: Return true only when all four lanes are empty.
        if((level1.peekFront() == null) && (level2.peekFront() == null)&& (level3.peekFront() == null)&& (level4.peekFront() == null)) return true;
        return false;
    }

    public int size() {
        // TODO: Return the total number of patients across all four lanes.
        return (level1.size() + level2.size() + level3.size() + level4.size());
    }
}
