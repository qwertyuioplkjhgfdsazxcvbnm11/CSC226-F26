package medical_action_tracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import patient_intake.Patient;

public class StudentCareTests {
    

    @Test
    void recursiveQueueEmpty() {
    LinkedQueue<String> queue = new LinkedQueue<>();
    assertEquals(0, queue.queueCount());
    assertEquals(queue.size(), queue.queueCount());
}
    @Test
    void recursiveQueueFull() {
    LinkedQueue<String> queue = new LinkedQueue<>();
    queue.enqueue("1");
    queue.enqueue("2");
    queue.enqueue("3");
    assertEquals(3, queue.queueCount());
    assertEquals(queue.size(), queue.queueCount());
    queue.dequeue();
    assertEquals(2, queue.queueCount());
    assertEquals(queue.size(), queue.queueCount());
}

    @Test
    void stackSizePopped() {
    LinkedStack<String> stack = new LinkedStack<>();
    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.pop();

    assertEquals(2, stack.size());
    assertEquals("[2, 1]", stack.toString());
}
    @Test
    void stackReuse() {
    LinkedStack<String> stack = new LinkedStack<>();
    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.pop();
    stack.pop();
    stack.pop();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());
    assertEquals("[]", stack.toString());
    stack.push("1");
    stack.push("2");
    stack.push("3");
    assertFalse(stack.isEmpty());
    assertEquals(3, stack.size());
    assertEquals("[3, 2, 1]", stack.toString());
    assertEquals("3", stack.peek());
}
    @Test
    void rejectsInvalidTriageLevels() {
    EmergencyWaitingRoom waitingRoom = new EmergencyWaitingRoom();
    Patient mark1 = new Patient("P00001", "mark", "marky", 14, "hungry", -1, "WaitingRoom", null, 14, "INS-123");
    Patient mark2 = new Patient("P00001", "mark", "marky", 14, "hungry", 0, "WaitingRoom", null, 14, "INS-123");
    Patient mark3 = new Patient("P00001", "mark", "marky", 14, "hungry", 5, "WaitingRoom", null, 14, "INS-123");
    assertFalse(waitingRoom.addPatient(mark1));
    assertFalse(waitingRoom.addPatient(mark2));
    assertFalse(waitingRoom.addPatient(mark3));
    assertEquals(0, waitingRoom.size());
}
    @Test
    void acceptsValidTriageLevels() {
    EmergencyWaitingRoom waitingRoom = new EmergencyWaitingRoom();
    Patient clark1 = new Patient("P00001", "Clark", "clarky", 41, "too full", 1, "WaitingRoom", null, 12, "INS-321");
    Patient clark2 = new Patient("P00002", "Clark", "clarky", 41, "too full", 2, "WaitingRoom", null, 12, "INS-321");
    Patient clark3 = new Patient("P00003", "Clark", "clarky", 41, "too full", 3, "WaitingRoom", null, 12, "INS-321");
    Patient clark4 = new Patient("P00004", "Clark", "clarky", 41, "too full", 4, "WaitingRoom", null, 12, "INS-321");
    assertTrue(waitingRoom.addPatient(clark1));
    assertTrue(waitingRoom.addPatient(clark2));
    assertTrue(waitingRoom.addPatient(clark3));
    assertTrue(waitingRoom.addPatient(clark4));
    assertEquals(4, waitingRoom.size());
}


///added more tests because I didnt realize that they were supposed to follow specific guidelines or whatever
/// the ones below should cover enough for the six of the eight Who knows im tired


    @Test
    void stackInOutThingy() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("testyyyying");
        assertEquals(1, stack.size());
        assertEquals("testyyyying", stack.peek());
        assertEquals("testyyyying", stack.pop());
        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
    }

     @Test
    void queueStringDoesntChangeeeeeee() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("are");
        queue.enqueue("we");
        queue.enqueue("good");
        assertEquals("[are, we, good]", queue.toString());
        assertEquals(3, queue.size());
        assertEquals("are", queue.peekFront());
    }

   @Test
    void prioritizeLevelOne() {
        EmergencyWaitingRoom room = new EmergencyWaitingRoom();
        Patient patientUno = new Patient("P00001", "Mr", "first", 41, "yaaa", 2, "WaitingRoom", null, 12, "INS-321");
        Patient patientDos = new Patient("P00002", "Mr", "second", 41, "yaaa", 1, "WaitingRoom", null, 12, "INS-321");
        Patient patientTres = new Patient("P00003", "Mr", "third", 41, "yaaa", 3, "WaitingRoom", null, 12, "INS-321");
        Patient patientQuatro = new Patient("P00004", "mr", "fourth", 41, "yaaa", 1, "WaitingRoom", null, 12, "INS-321");
        room.addPatient(patientUno);
        room.addPatient(patientDos);
        room.addPatient(patientTres);
        room.addPatient(patientQuatro);
        assertEquals("P00002", room.nextPatient().getPatientID());
        assertEquals("P00004", room.nextPatient().getPatientID());
        assertEquals("P00001", room.nextPatient().getPatientID());
        assertEquals("P00003", room.nextPatient().getPatientID());
    }

    @Test
    void doesItGoInOrdaaaa() {
        EmergencyWaitingRoom room = new EmergencyWaitingRoom();
        assertTrue(room.isEmpty());
        assertNull(room.nextPatient());
        Patient patientUno = new Patient("P00001", "Mr", "first", 41, "yaaa", 1, "WaitingRoom", null, 12, "INS-321");
        Patient patientDos = new Patient("P00002", "Mr", "first", 41, "yaaa", 1, "WaitingRoom", null, 12, "INS-321");
        Patient patientTres = new Patient("P00003", "Mr", "first", 41, "yaaa", 1, "WaitingRoom", null, 12, "INS-321");
        room.addPatient(patientUno);
        room.addPatient(patientDos);
        room.addPatient(patientTres);
        assertEquals("P00001", room.nextPatient().getPatientID());
        assertEquals("P00002", room.nextPatient().getPatientID());
        assertEquals("P00003", room.nextPatient().getPatientID());
        assertTrue(room.isEmpty());
    }




}
