package medical_action_tracking;

public class LinkedQueue<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        // TODO: Initialize an empty queue.
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T item) {
        // TODO: Add a node at the rear. Update both references when the queue is empty.
        if(item == null) throw new IllegalArgumentException("item can't be null");
        if(front == null){
            rear = new Node(item);
            front = rear;
        } else{
            rear.next = new Node(item);
            rear = rear.next;
        }
        ++size;
    }

    public T dequeue() {
        // TODO: Remove and return the front item, or return null if empty.
        // TODO: When removing the last item, make both front and rear null.
        if(front == null) {
            return null;
        } 
        Node temp;
        temp = front;
        front = front.next;
        --size;

        if(front == null){    
            rear = null;
        } 
        return temp.data;
    }

    public T peekFront() {
        // TODO: Return the front item without removing it, or null if empty.
        if(front == null) {return null;}
        else{
            return front.data;
        }
    }

    public boolean isEmpty() {
        // TODO: Determine whether the queue contains any items.
         if(front == null) {return true;}
        else{
            return false;
        }
    }

    public int size() {
        // TODO: Return the number of queued items.
        return size;
    }

    @Override
    public String toString() {
        // TODO: Recursively build a string from front to rear without changing the queue.
        StringBuilder result = new StringBuilder("[");
        appendNodesRecursively(front, result);
        return result.toString() + "]";
    }

    private void appendNodesRecursively(Node current, StringBuilder result) {
        // TODO: Add the current node's data, then recursively visit current.next.
        // TODO: Stop at the null-node base case.
        if (current == null){
            return;
        }
        result.append(current.data);
        if (current.next != null) {
        result.append(", ");
        }
        appendNodesRecursively(current.next, result); 

    }

//extension recursive queue count: add a recursive method that counts the nodes in a queue and compare its result with size(); test empty and multi-node queues
public int queueCount() {
    return recursiveQueueCount(front);
}


private int recursiveQueueCount(Node current) {
    if (current == null) return 0;
    return 1 + recursiveQueueCount(current.next);
}
}
