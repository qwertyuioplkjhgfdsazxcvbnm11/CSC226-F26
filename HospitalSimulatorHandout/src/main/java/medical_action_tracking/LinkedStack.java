package medical_action_tracking;

public class LinkedStack<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public void push(T item) {
        // TODO: Reject null items, then link a new node at the top and update size.
        if(item == null) throw new IllegalArgumentException("item can't be null");
        Node temp = new Node(item);
        temp.next = top;
        top = temp;
        ++size;
    }

    public T pop() {
        // TODO: Remove and return the top item, or return null when empty.
        if(top == null)return null;
        Node result = top;
        top = result.next;
        --size;
        return result.data;
    }

    public T peek() {
        // TODO: Return the top item without removing it, or null when empty.
        if(top == null) return null;
        else return top.data;
    }

    public boolean isEmpty() {
        // TODO: Determine whether the stack contains any items.
        if(top == null) return true;
        else return false;
    }

    public int size() {
        // TODO: Return the number of stacked items.
        //loop through and count
        return size;
    }

    @Override
    public String toString() {
        // TODO: Build [top, next, ...] by traversing the stack without changing it.
        
        String returning = "[";
        Node toppy = top;
        while (toppy != null) {
            returning += toppy.data;
            if (toppy.next != null) returning += ", ";
            toppy = toppy.next;
        }
        returning += "]";
        return returning;
    }
}
