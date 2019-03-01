# SortingAlgorithms

- Program to analyze 7 different sorting algorithms.
- To achieve this goal, need to create a random number generator and then 7 programs for each sorting method that are under the ASort abstract class. On the command line, the only information the program needs from the user is the <seed> and <count> for the random numbers. I will be testing the timing of each sorting alogorithm by using the Linux command /usr/bin/time to output the time taken by each sort
- Moreover, once the code works, I will be comparing and contrasting these sorting algorithms through an empirical study which will be called 'empirical-study.pdf'. In this document, I will have 2 tables: 1 for the timeliness of user time and the other for the timeliness of elapsed time. In the table, the variable C will be equivalent to the number I use for <count> where Patrick's sort or bubble sort takes approximately 10 seconds. I will then record data for C, 2C, 4C, 8C, and 16C.
- Lastly, I will be doing a Cheater Check. Here, I will be testing Patrick's bubble sort with all random numbers that have a 9 in it or 9 digit.I will need to include the 2 command lines that check this. One using grep that will run one of the sorts with only numbers that inclide at least one "9" digit. Then the other command line that filters out all numbers that include a "9" digit. Then I will test if Spongebob was right that digits '9' make Patrick's bubble sort sort faster!

## Reflection
- On empirical-study.pdf
- Charts on empirical-charts.pdf
- Graph attached from gnuplot called empirical-graph.png
-Reflect on the relationship between the run times and the relative challenge (the number of bugs, time taken to code, code length, etc.) of coding different sorts
1. Bubble sort (Patrick)
2. Selection sort (Squidward)
3. Insertion sort (Mr. Krabs)
4. Quick sort (Spongebob)
5. Tree sort (Sandy)
6. Heap sort (Planketon)
7. Merge sort (Gary)

