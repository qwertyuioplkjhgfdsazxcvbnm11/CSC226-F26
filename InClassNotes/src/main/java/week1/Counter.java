package week1;

public class Counter {
    
 
     // 2. Add a private field
    private int count;
    private int length;
    private int history[];

        // 3. Write the default constructor
    public Counter(){
        count = 0;
        length = 0;
        history = new int [5];
    }

        // 4. Add an alternate constructor
     public Counter(int count){
        this.count = count;
        addToHistoryArray();
        length = 0;
        history = new int [5];
    }

    // 5. Write an accessor method
    public int getCount(){
        return count;
    }

        // 6. Add an update method
    public void incrementCount(){
        count++;
        addToHistoryArray();
    }

      // 7. Overload increment
    public void incrementCount(int num){
        count+= num;
        addToHistoryArray();
    }

    
        // 8. Add a reset method
    public void resetCount(){
        count = 0;
        addToHistoryArray();
    }

    //9. Add a fixed-size history array that records the last 5 states of the counter. All logic must happen inside of the object and be hidden from the user.
    private void addToHistoryArray(){
        if(length < 5){
            history[length] = count;
            length++;
        } else{
            for(int i = 0; i < 4; i++){
                history[i] = history[i+1];
            }
            history[4] = count;
        }
    }
}