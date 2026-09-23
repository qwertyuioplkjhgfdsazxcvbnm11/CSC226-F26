Timing:

Size     -- Linear Search Time -- Binary Search Time -- Alt O(log n) Search Time
100      -- 8807 ns            -- 21420 ns           -- 50595 ns
1,000    -- 72034 ns           -- 19436 ns           -- 49654 ns 
10,000   -- 2500594 ns         -- 24836 ns           -- 54682 ns
100,000  -- 6490905 ns         -- 34695 ns           -- 54933 ns

I'd recommend binary search (essentially any O(log n)). From my short time using it it is the fastest of the search methods and it also took less lines to code. In general the speed of these O(log n) searches doesn't change very heavily based on the number of people in the array. However, these values might not be 100% trustworthy. This was a very small dataset.

 Sources for work:
 Exponential: 
    https://youtu.be/UqJGfFrwkGE 
    https://www.geeksforgeeks.org/dsa/exponential-search/
 Binary:
    https://youtu.be/xrMppTpoqdw
    https://www.geeksforgeeks.org/dsa/binary-search/

 The results demonstrate the Big O classifications of all three search types tried. Linear seems to substantially increase as the size increases. Binary and exponential on the other hand stay relatively steady with slight variance which could be attributed to 'randomness'. 

1. As the dataset grows by 10x each time, how does each algorithm's time change on average?
    -Linear: with every 10x iteration linear gets substantially larger.
    -Binary: with every 10x iteration binary stays roughyly the same speed, only beginning to slow down a little at 100,000
    -Exponential: with every 10x iteration exponential stays roughly the same speed.
2. Carroll Memorial Hospital sees about 50,000 patients per year. Which search algorithm would you recommend? Why?
    -I would recommend binary. In my short time testing them binary was consistently the lowest time.  
3. Is measuring time in this way the best way to assess algorithmic efficiency?
    -No, it's useful to compare algorithms like this but as a standalone option its not very good. A better option would be looking at their Big O classifications to estimate how they would behave with different sized data types.



