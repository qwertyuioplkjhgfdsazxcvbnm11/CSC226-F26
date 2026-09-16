package patient_intake;

public class Patient extends Person {
    private String patientID;
    private String chiefComplaint;
    private int triageLevel;
    private String currentStage;
    private String assignedRoom;
    private int arrivalHour;
    private String insuranceID;

    public Patient(String patientID, String firstName, String lastName, int age,
            String chiefComplaint, int triageLevel, String currentStage,
            String assignedRoom, int arrivalHour, String insuranceID) {
        super(firstName, lastName, age);

        // TODO REQUIRED: Initialize the patient-specific fields.
        this.patientID = patientID;
        this.chiefComplaint = chiefComplaint;
        this.triageLevel = triageLevel;
        this.currentStage = currentStage;
        this.assignedRoom = assignedRoom;
        this.arrivalHour = arrivalHour;
        this.insuranceID = insuranceID;

    }

    // Getters
    public String getPatientID() {
        return this.patientID; // TODO REQUIRED: Return the patient ID.
    }

    public String getFirstName() {
        return this.firstName; // TODO REQUIRED: Return the first name.
    }

    public String getLastName() {
        return this.lastName; // TODO REQUIRED: Return the last name.
    }

    public int getAge() {
        return this.age; // TODO REQUIRED: Return the age.
    }

    public String getChiefComplaint() {
        return this.chiefComplaint; // TODO REQUIRED: Return the chief complaint.
    }

    public int getTriageLevel() {
        return this.triageLevel; // TODO REQUIRED: Return the triage level.
    }

    public String getCurrentStage() {
        return this.currentStage; // TODO REQUIRED: Return the current stage.
    }

    public String getAssignedRoom() {
        return this.assignedRoom; // TODO REQUIRED: Return the assigned room.
    }

    public int getArrivalHour() {
        return this.arrivalHour; // TODO REQUIRED: Return the arrival hour.
    }

    public String getInsuranceID() {
        return this.insuranceID; // TODO REQUIRED: Return the insurance ID.
    }

    // Setters
    public void setPatientID(String patientID) {
        this.patientID = patientID; // TODO REQUIRED: Update the patient ID.
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName; // TODO REQUIRED: Update the first name.
    }

    public void setLastName(String lastName) {
        this.lastName = lastName; // TODO REQUIRED: Update the last name.
    }

    public void setAge(int age) {
         // TODO REQUIRED: Update the age.
    // OPTIONAL (+5%): Reject ages outside the range 0 through 120.
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
        }
        this.age = age;
    }

   
    

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint; // TODO REQUIRED: Update the chief complaint.
    }

    public void setTriageLevel(int triageLevel) {
        this.triageLevel = triageLevel; // TODO REQUIRED: Update the triage level.
    }

    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage; // TODO REQUIRED: Update the current stage.
    }

    public void setAssignedRoom(String assignedRoom) {
        this.assignedRoom = assignedRoom; // TODO REQUIRED: Update the assigned room.
    }

    public void setArrivalHour(int arrivalHour) {
        this.arrivalHour = arrivalHour; // TODO REQUIRED: Update the arrival hour.
    }

    public void setInsuranceID(String insuranceID) {
        this.insuranceID = insuranceID; // TODO REQUIRED: Update the insurance ID.
    }

    @Override
    // patientID,name,age,chiefComplaint,triageLevel,currentStage,assignedRoom,arrivalHour,insuranceID
    public String toString() {
        return "Patient ID: " + this.patientID + ", " + this.firstName + " " + this.lastName + ", " + this.age
                + " years old, complains of " + this.chiefComplaint + ", priority level " + this.triageLevel + "."
                + "Their arrival hour is: " + this.arrivalHour + ", they were assigned to room " + this.assignedRoom
                + ". For billing their insurance id is: " + this.insuranceID; // TODO REQUIRED: Return a useful
                                                                              // representation of a patient.
    }
}