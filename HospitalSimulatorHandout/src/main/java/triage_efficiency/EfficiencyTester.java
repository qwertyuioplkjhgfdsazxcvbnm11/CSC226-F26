package triage_efficiency;

import java.util.*;
import patient_intake.Patient;

public class EfficiencyTester {

    /**
     * REQUIRED (80%): Implement linear search.
     *
     * Search through the patient array one element at a time until the matching
     * patientID is found. Return the Patient if it exists; otherwise return null.
     *
     * This method must run in O(n) time.
     */
    public Patient linearSearch(Patient[] patients, String pid) {
        long startTime = System.nanoTime();
        // TODO REQUIRED: Implement linear search.
        // Search the entire array in order and return the matching Patient.
        for (int i = 0; i < patients.length; i++) {
            if (patients[i].getPatientID().equals(pid)) {
                long endTime = System.nanoTime();
                System.out.println("The linear search took: " + (endTime - startTime) + " ns");
                return patients[i];
            }
        }
        long endTime = System.nanoTime();
        System.out.println("The linear search took: " + (endTime - startTime) + " ns");
        return null;
    }

    /**
     * REQUIRED (80%): Implement binary search.
     *
     * This method works only on an array that is sorted by patientID.
     * Repeatedly divide the search range in half until the target is found.
     *
     * This method must run in O(log n) time.
     */
    public Patient binarySearch(Patient[] patients, String pid) {
        long startTime = System.nanoTime();
        // TODO REQUIRED: Implement iterative binary search.
        // The array must be sorted by patientID before calling this method.

        //reformatting the id being searched for. substring removes the P so that only numbers remain and parseint converts the remaining numbers from string to int 
        int goal = Integer.parseInt(pid.substring(1));  

        //sets bottom boundary to lowest array index
        int low = 0;

        //sets top boundary to highest array index                    
        int high = patients.length - 1;

        //searches the array  
        while (low <= high) { 

            //finds the middle index of the current range
            int middle = low + (high - low) / 2; 

            //converts middleID into an int so it can be compared to the goalID
            int middleID = Integer.parseInt(patients[middle].getPatientID().substring(1)); 

            //if middle id is below the goal id it moves the bottom boundary to the mid point + 1 so its just the upper half
            if (middleID < goal) low = middle + 1;

            //if middle id is above the goal id it moves the top boundary to the mid point -1 so its just the lower half          
            else if (middleID > goal) high = middle - 1;

            
            //returns patient once middle id is the goal id    
            else {
                long endTime = System.nanoTime();
                System.out.println("The binary search took: " + (endTime - startTime) + " ns");
                return patients[middle]; }

            }
            long endTime = System.nanoTime();
            System.out.println("The binary search took: " + (endTime - startTime) + " ns");
        return null; 
    }

    
    /**
     * OPTIONAL (+5%): Implement a different O(log n) search algorithm.
     *
     * Pick one of the following approaches and implement it:
     * - Exponential search
     * - Jump search
     * - Ternary search
     *
     * Add a short comment above the method explaining:
     * - which algorithm you chose
     * - where you learned about it
     * - why it works
     */

    // Exponential search
    // These were my sources for where I learned how to do it (also googling random questions)
    // https://youtu.be/UqJGfFrwkGE 
    // https://www.geeksforgeeks.org/dsa/exponential-search/
    // It minimizes the required search area by exponentially increasing a bound value, then once it finds the range it runs a typical binary search within that condensed search area
    public Patient logNSearch(Patient[] patients, String pid) {
        long startTime = System.nanoTime();
        // TODO OPTIONAL: Research and implement a second O(log n) algorithm.
        // Cite your source and explain the approach in a comment before the logic.
        int bound = 1;

        //returns null if passed array is empty
        if (patients.length == 0) {
            long endTime = System.nanoTime();
            System.out.println("The exponential search took: " + (endTime - startTime) + " ns");
            return null;} 

        //return patient if the first index is the correct id
        else if (patients[0].getPatientID().equals(pid)) {
            long endTime = System.nanoTime();
            System.out.println("The exponential search took: " + (endTime - startTime) + " ns");
            return patients[0]; }

        //first part of the loop verifies that it wont accidentally go beyond the end of the array
        //second part of the loop is evaluating if the current patient id at the current bound is less than the patient id value im looking for
        while(bound < patients.length && Integer.parseInt(patients[bound].getPatientID().substring(1)) < Integer.parseInt(pid.substring(1))){

            //doubles bound exponentially to find the range that contains the pid youre looking for
            bound *=2; 
            }
            //brings the lefthand value of the search area to the previous bound value (when the pid youre searching for is still greater than it)
            int low = bound / 2; 

            //sets the right value of the search area to either the end of the array or the current bound position (which is greater than the pid value youre looking for) -- whichever is smaller
            int high = Math.min(bound, patients.length -1); 

            //reformatting the id being searched for. substring removes the P so that only numbers remain and parseint converts the remaining numbers from string to int 
            int goal = Integer.parseInt(pid.substring(1));

            //**binary search logic copy pasted and slightly altered:**
            // (cannot call the method because it does not allow the passing of low and high (left and right) values. (I do not know if I'm allowed to change that))

            //searches the array 
            while (low <= high) { 

                //finds the middle index of the current range
                int middle = low + (high - low) / 2; 

                //converts middleID into an int so it can be compared to the goalID
                int middleID = Integer.parseInt(patients[middle].getPatientID().substring(1)); 

                //if middle id is below the goal id it moves the bottom boundary to the mid point + 1 so its just the upper half
                if (middleID < goal) low = middle + 1;          

                //if middle id is above the goal id it moves the top boundary to the mid point -1 so its just the lower half
                else if (middleID > goal) high = middle - 1;    

                //returns patient once middle id is the goal id   
                else {
                long endTime = System.nanoTime();
                System.out.println("The exponential search took: " + (endTime - startTime) + " ns");
                return patients[middle]; 
                }
                    
        }
        long endTime = System.nanoTime();
        System.out.println("The exponential search took: " + (endTime - startTime) + " ns");
        return null; 
    }






    public void timeDemo() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 + 5;
        }
        long endTime = System.nanoTime();

        System.out.println("The example addition took: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 * 5;
        }
        endTime = System.nanoTime();
        System.out.println("The example multiplication took: " + (endTime - startTime) + " ns");
    }
}
