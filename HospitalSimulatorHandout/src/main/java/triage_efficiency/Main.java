package triage_efficiency;

import patient_intake.Patient;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // TODO REQUIRED: Generate the patient data.
        // TODO REQUIRED: Sort the data by patientID when needed.
        // TODO REQUIRED: Run each search method and print a found and not-found
        // example.
        // TODO OPTIONAL: Call timeDemo() to compare algorithm runtimes.

        Patient[] patients = generatePatients(20);
        patients = sortByPatientId(patients);

        EfficiencyTester test = new EfficiencyTester(); // creates efficiency tester object to be able to call methods from efficiency tester 

        //found
        System.out.println("Searching for P00005: " + test.linearSearch(patients, "P00005"));
        //not found
        System.out.println("Searching for P00050: " + test.linearSearch(patients, "P00050"));

        //found
        System.out.println("Searching for P00010: " + test.binarySearch(patients, "P00010"));
        //not found
        System.out.println("Searching for P00100: " + test.binarySearch(patients, "P00100"));
        
        //found
        System.out.println("Searching for P00015: " + test.logNSearch(patients, "P00015"));
        //not found
        System.out.println("Searching for P00150: " + test.logNSearch(patients, "P00150"));


        //this is supposed to be the optional work for this:
        // TODO OPTIONAL: Call timeDemo() to compare algorithm runtimes.
        //I just now realized that says to call that so i was probably supposed to do something with that and not
        //just implement the stuff into my methods but I don't know and its late and this worked so I'm leaving it

        Patient[] patients3 = generatePatients(100000);
        patients3 = sortByPatientId(patients3);
        System.out.println("Timer stuff");

        test.linearSearch(patients3, patients3[patients3.length / 2].getPatientID());

        test.binarySearch(patients3, patients3[patients3.length / 2].getPatientID());

        test.logNSearch(patients3, patients3[patients3.length / 2].getPatientID());


    }

    /**
     * REQUIRED (80%): Generate sample patient data for testing.
     *
     * Build an array of Patient objects with realistic IDs, names, complaints,
     * and triage information so you can test each search method.
     */
    public static Patient[] generatePatients(int count) {
        // TODO REQUIRED: Create the patient array and fill it with sample data.
        Patient[] patients = new Patient[count];
        Random random = new Random();
        // patientID,name,age,chiefComplaint,triageLevel,currentStage,assignedRoom,arrivalHour,insuranceID
        String[] firstNames = { "Liam", "Sophia", "Jackson", "Olivia", "Ethan", "Mia", "Lucas", "Harper", "Noah",
                "Emma", "Oliver", "Ava", "Elijah", "Isabella", "Mateo" };
        String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Wilson",
                "Anderson", "Taylor", "Thomas", "Moore", "Jackson", "Martin", "White" };
        int[] ages = { 46, 18, 58, 64, 65, 17, 28, 43, 24, 22, 76, 51, 26, 36, 54 };
        String[] chiefComplaint = { "Chest pain", "Muscle weakness", "Difficulty breathing", "Headache",
                "Loss of consciousness", "Severe abdominal pain", "Burns", "Bleeding out", "Confusion", "Brain fog",
                "Concussion", "High fever", "Snake bite", "Vision loss", "Anaphylaxis" };
        String[] currentStage = { "Admission", "Triage", "Waiting", "Treatment", "Recovery" };
        String[] assignedRoom = { "ER-101", "ER-102", "ER-103", "ER-104", "ER-105", "ER-201", "ER-202", "ER-203",
                "ER-204", "ER-205", "Waiting room" };
        int[] arrivalHours = { 2, 14, 19, 8, 1, 9, 5, 22, 11, 12, 20, 2, 10, 7, 3 };
        String[] insuranceID = { "INS-50562", "INS-90295", "INS-98330", "INS-71766", "INS-83381", "INS-88293",
                "INS-86492", "INS-44315", "INS-85371", "INS-23558", "INS-26517", "INS-23538", "INS-85622",
                "INS-63875" };
        for (int i = 0; i < count; i++) {
            int triageLevel = 0;
            String complaint = chiefComplaint[random.nextInt(chiefComplaint.length)];
            if (complaint.equalsIgnoreCase("Bleeding out") || complaint.equalsIgnoreCase("Loss of consciousness")
                    || complaint.equalsIgnoreCase("Anaphylaxis"))
                triageLevel = 1;
            else if (complaint.equalsIgnoreCase("Difficulty breathing") || complaint.equalsIgnoreCase("Chest pain")
                    || complaint.equalsIgnoreCase("Vision loss") || complaint.equalsIgnoreCase("Confusion")
                    || complaint.equalsIgnoreCase("Snake bite") || complaint.equalsIgnoreCase("Severe abdominal pain"))
                triageLevel = 2;
            else if (complaint.equalsIgnoreCase("Burns") || complaint.equalsIgnoreCase("High fever"))
                triageLevel = 3;
            else if (complaint.equalsIgnoreCase("Muscle weakness") || complaint.equalsIgnoreCase("Concussion")
                    || complaint.equalsIgnoreCase("Headache"))
                triageLevel = 4;
            else if (complaint.equalsIgnoreCase("Brain fog"))
                triageLevel = 5;
            patients[i] = new Patient(
                    "P" + String.format("%05d", i + 1),
                    firstNames[random.nextInt(firstNames.length)],
                    lastNames[random.nextInt(lastNames.length)],
                    ages[random.nextInt(ages.length)],
                    complaint,
                    triageLevel,
                    currentStage[random.nextInt(currentStage.length)],
                    assignedRoom[random.nextInt(assignedRoom.length)],
                    arrivalHours[random.nextInt(arrivalHours.length)],
                    insuranceID[random.nextInt(insuranceID.length)]);
        }
        return patients;
    }

    /**
     * 
     * REQUIRED (80%): Sort patients by patientID before binary search.
     *
     * The binary-search version only works on an array sorted by patientID.
     */
    public static Patient[] sortByPatientId(Patient[] patients) {
        // TODO REQUIRED: Sort the array by patientID before testing binary search.
        for (int i = 1; i < patients.length; i++) {
            Patient currentPatient = patients[i];
            int j = i - 1;
            //comments for while loop
            // (J >= 0) - checks to make sure j isnt below zero (invalid array index) so it doesnt throw an error. Also checks to see if the first value is larger than the second, 
            //the rest of the while loop: Checks if the patient to the left of the patient currently being sorted has a larger or smaller id. 
            // If the id of the patient on the left is larger, the while loop will run and shift the patient on the left to the right. 
            // If the id is smaller the while loop doesnt run and the for loop iterates moving on to the next patient.  
            while (j >= 0 && patients[j].getPatientID().compareTo(currentPatient.getPatientID()) > 0) { 
                patients[j + 1] = patients[j]; // shifts the patient object to the right one
                j--; //decrements j so that you can place the value youre sorting left
            }
            patients[j + 1] = currentPatient; //sets the value on the left to patient
        }
        return patients; //returns sorted array
    }
    //add comments to explain what does what
}
