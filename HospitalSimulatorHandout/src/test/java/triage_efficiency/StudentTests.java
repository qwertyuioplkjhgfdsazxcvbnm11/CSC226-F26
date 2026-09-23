package triage_efficiency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import patient_intake.Patient;

public class StudentTests {
    
EfficiencyTester test = new EfficiencyTester();



//It's important because linear search should still work when the array only has one patient within it.
@Test
void testLinearSearchWithASinglePatient() {
    Patient[] patients = Main.generatePatients(1);

    Patient result = test.linearSearch(patients, "P00001");
    assertNotNull(result, "Linear search should find a patient that exists in the array, even if there is only one.");
    assertEquals("P00001", result.getPatientID(), "Linear search should return the right patient ID.");
}


//It's important because binary search should not be able to return anything if the id provided is not one of the ids within its array.
//If it returns anything other than null something is wrong.
@Test
void testBinarySearchWithFakeID() {
    Patient[] patients = Main.generatePatients(25);

    Patient result = test.binarySearch(patients, "P00000");
    assertNull(result, "Binary search should return null if the ID doesn't exist in the array.");
}

//It's important to the function of exponential search that it returns null when the array doesn't have any patients in it, otherwise it will cause an error.
@Test
void testExponentialSearchWithNoPatients() {
    Patient[] patients = Main.generatePatients(0);

    Patient result = test.logNSearch(patients, "P00001");
    assertNull(result, "Exponential search should return null when the array doesn't have any patients in it.");
}

//It's important because linear search checks the array linearly (beginning to end). Testing the last patient makes sure the method doesn't accidentally stop before reaching the end.
@Test
void testLinearSearchWithTheLastPatient() {
    Patient[] patients = Main.generatePatients(15);

    Patient result = test.linearSearch(patients, "P00015");
    assertNotNull(result, "Linear search should find a patient that exists last in the array, even if it is the last one.");
    assertEquals("P00015", result.getPatientID(), "Linear search should return the right patient ID.");
}

//It's important to the function of linear search that it returns null when the array doesn't have any patients in it, otherwise it will cause an error.
@Test
void testLinearSearchWithNoPatients() {
    Patient[] patients = Main.generatePatients(0);

    Patient result = test.linearSearch(patients, "P00001");
    assertNull(result, "Linear search should return null when the array doesn't have any patients in it.");
}



//It's important to the function of binary search that it returns null when the array doesn't have any patients in it, otherwise it will cause an error.
@Test
void testBinarySearchWithNoPatients() {
    Patient[] patients = Main.generatePatients(0);

    Patient result = test.binarySearch(patients, "P00001");
    assertNull(result, "Binary search should return null when the array doesn't have any patients in it.");
}




}
