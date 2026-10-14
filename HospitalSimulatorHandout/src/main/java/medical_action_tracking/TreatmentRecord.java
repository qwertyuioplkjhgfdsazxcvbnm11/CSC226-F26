package medical_action_tracking;

public class TreatmentRecord {
    private String patientID;
    private String treatmentName;
    private String timestamp;

    public TreatmentRecord(String patientID, String treatmentName, String timestamp) {
        this.patientID = patientID;
        this.treatmentName = treatmentName;
        this.timestamp = timestamp;
    }

    public String getPatientID() {
        // TODO: Return the patient ID.
        return this.patientID;
    }

    public String getTreatmentName() {
        // TODO: Return the treatment description.
        return this.treatmentName;
    }

    public String getTimestamp() {
        // TODO: Return the timestamp.
        return this.timestamp;
    }

    @Override
    public String toString() {
        // TODO: Return "timestamp | patientID | treatmentName".
        return this.timestamp + " | " + this.patientID + " | " + this.treatmentName;
    }
}
