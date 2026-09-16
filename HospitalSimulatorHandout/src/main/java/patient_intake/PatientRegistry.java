package patient_intake;
// Switch from using ArrayList to a flat array implementation for patient storage.

public class PatientRegistry {
    // Flat array to store patients and a size field to track the number of stored
    // patients.
    private Patient[] patientRegistry;
    private int size; // track actual number of patients

    // Initial capacity for the flat array. Can be adjusted as needed.
    private static final int INITIAL_CAPACITY = 10;

    public PatientRegistry() {
        // TODO REQUIRED: Create the initial array and set the starting size.
        patientRegistry = new Patient[INITIAL_CAPACITY];
        size = 0;
    }

    public void addPatient(Patient patient) {
        // TODO REQUIRED: Add a patient to the registry.
        patientRegistry[size] = patient;
        size++;
        // TODO OPTIONAL (+5%): Expand the array when it becomes full.
        if (patientRegistry.length == size) {
            Patient[] patientRegistry2 = new Patient[patientRegistry.length * 3];
            for (int i = 0; i < size; i++) {
                patientRegistry2[i] = patientRegistry[i];
            }
            patientRegistry = patientRegistry2;
        }

    }

    /**
     * Returns the patients currently stored in the registry.
     * The optional encapsulation extension requires returning a defensive copy.
     */
    public Patient[] getPatientRegistry() {
        // TODO REQUIRED: Return the patients currently stored.
        Patient[] defensiveCopy = new Patient[size];
        for (int i = 0; i < size; i++) {
            defensiveCopy[i] = patientRegistry[i];
        }
        return defensiveCopy;
    }

    public Patient getPatientByID(String patientID) {
        // TODO REQUIRED: Search for and return the matching patient.
        for (int i = 0; i < size; i++) {
            if (patientRegistry[i].getPatientID().equals(patientID)) {
                return patientRegistry[i];
            }
        }
        return null;
    }

    /**
     * Removes a patient from the registry by patientID.
     * 
     * @param patientID The ID of the patient to remove
     * @return true if patient was found and removed, false otherwise
     */
    public boolean removePatient(String patientID) {
        for (int i = 0; i < size; i++) {
            // TODO OPTIONAL (+5%): Remove the patient with this ID.
            if (patientRegistry[i].getPatientID().equals(patientID)) {
                for (int j = i; j < size - 1; j++) {
                    patientRegistry[j] = patientRegistry[j + 1];
                }
                size--;
                patientRegistry[size] = null;

                return true;
            }
        }
        return false;
    }

    /**
     * Removes a patient from the registry by index.
     * 
     * @param index The index of the patient to remove
     * @return the removed Patient, or null if index is invalid
     */
    public Patient removePatient(int index) {
        // TODO OPTIONAL (+5%): Remove by index and shift later elements left.
        if (index >= 0 && index < size) {
            Patient deletedPatient = patientRegistry[index];

            for (int i = index; i < size - 1; i++) {
                patientRegistry[i] = patientRegistry[i + 1];
            }
            size--;
            patientRegistry[size] = null;
            return deletedPatient;
        } else {
            return null;
        }

    }

    /**
     * Updates a patient in the registry by matching patientID.
     * 
     * @param updatedPatient The patient with updated information
     * @return true if patient was found and updated, false otherwise
     */
    public boolean updatePatient(Patient updatedPatient) {
        // TODO OPTIONAL (+5%): Replace the patient with the same ID.
        for (int i = 0; i < size; i++) {
            if (updatedPatient.getPatientID().equals(patientRegistry[i].getPatientID())) {
                patientRegistry[i] = updatedPatient;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO REQUIRED: Return a useful representation of the registry.
        String info = "PatientRegistry size: " + size + "\nPatients (Name - ID): \n";
        for (int i = 0; i < size; i++) {
            info += patientRegistry[i].getFirstName() + " " + patientRegistry[i].getLastName() + " - "
                    + patientRegistry[i].getPatientID() + "\n";
        }
        return info;
    }

}
