package patient_intake;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class StudentAdditionalTests {

    private PatientRegistry registry;
    private Patient patient1;
    private Patient patient2;
    private Patient patient3;

    @BeforeEach
    void setUp() {
        registry = new PatientRegistry();

        patient1 = new Patient(
                "P001",
                "Michael",
                "Man",
                32,
                "Heart palpitations",
                3,
                "Waiting",
                "Room1",
                6,
                "INS123");
        patient2 = new Patient(
                "P002",
                "Billy",
                "Dilly",
                18,
                "Headache",
                2,
                "Waiting",
                "Room2",
                3,
                "INS321");

        patient3 = new Patient(
                "P003",
                "Billy",
                "Bob",
                42,
                "ouchie ouch",
                4,
                "Waiting",
                "Room3",
                16,
                "INS654321");
    }

    @Test
    void testRemovePatientString() {
        registry.addPatient(patient1);
        assertTrue(registry.removePatient("P001"));
        assertNull(registry.getPatientByID("P001"));
    }
    //patient needs to be removable via id

    @Test
    void testRemovePatientInvalidString() {
        registry.addPatient(patient1);
        assertFalse(registry.removePatient("P002"));
        assertNotNull(registry.getPatientByID("P001"));
    }
    //patient should not be removed when submitting an invalid patient id

    @Test
    void testRemovePatientInt() {
        registry.addPatient(patient1);
        assertNotNull(registry.removePatient(0));
        assertNull(registry.getPatientByID("P001"));
    }
    //patient needs to be removable via index

    @Test
    void testRemovePatientInvalidInt() {
        registry.addPatient(patient1);
        assertNull(registry.removePatient(2));
        assertNotNull(registry.getPatientByID("P001"));
    }
    //patient should not be removed when submitting an invalid patient index

    @Test
    void testUpdatePatient() {
        registry.addPatient(patient1);
        Patient updatedPatient = new Patient(
                "P001",
                "Michael",
                "Woman",
                33,
                "Heart break",
                3,
                "Waiting",
                "Room1",
                6,
                "INS123");

        assertTrue(registry.updatePatient(updatedPatient));
        assertEquals(33, registry.getPatientByID("P001").getAge());
        assertEquals("Woman", registry.getPatientByID("P001").getLastName());
        assertEquals("Heart break", registry.getPatientByID("P001").getChiefComplaint());
    }
    //you need to be able to update patients in case their status changes

    @Test
    void testGetPatientRegistry() {
        registry.addPatient(patient1);
        registry.addPatient(patient2);
        registry.addPatient(patient3);
        Patient[] patients = registry.getPatientRegistry();

        assertEquals("P001", patients[0].getPatientID());
        assertEquals("P002", patients[1].getPatientID());
        assertEquals("P003", patients[2].getPatientID());
        assertEquals(3, patients.length);
    }
    //if you cannot get the registry it is useless

}
