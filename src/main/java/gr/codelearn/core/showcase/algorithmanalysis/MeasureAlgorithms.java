package gr.codelearn.core.showcase.algorithmanalysis;

import java.util.*;
import java.util.Random;

public class MeasureAlgorithms {
    public static void main(String[] args) {
        //measureSortingTime();
        //logarithmicComplexity();
        complexityOfLists();
    }

    public static void logarithmicComplexity() {
        int n = 1000;
        int count = 0;

        for (int i=1; i<=n; i=i*2) {
            count++;
        }
        System.out.println("Input n=" + n + " / Number of steps=" + count);
    }

    public static int[] getArray(){
        int arraySize = 300000;
        int[] items = new int[arraySize];

        Random randGenerator = new Random();
        for (int i=0; i<items.length; i++) {
            items[i] = randGenerator.nextInt();
        }
        return items;
    }

    public static void measureSortingTime(){
        int [] items = getArray();
        long timeBefore, timeAfter, ellapsedTimeInMills;
        double ellapsedTimeInSecs;

        System.out.println("Started the sorting procedure of " + items.length + " elements. Please wait ...");
        timeBefore = System.currentTimeMillis();
        insertionSort( items );
        // Change to Arrays.sort to see how much faster it is
        // Arrays.sort(items);
        timeAfter = System.currentTimeMillis();
        ellapsedTimeInMills = (timeAfter-timeBefore);
        ellapsedTimeInSecs = (double)(timeAfter-timeBefore)/1000;
        System.out.println( "Sorting procedure finished." );
        System.out.println("Ellapsed Time in Milliseconds: " + ellapsedTimeInMills);
        System.out.println("Ellapsed Time in Seconds: " + ellapsedTimeInSecs);
    }

    public static void insertionSort(int[] theArray) {
        insertionSort(theArray,theArray.length);
    }

    private static void insertionSort(int[] theArray, int n) {
        for (int i=1; i<n; i++) {
            int temp=theArray[i];
            int loc=i;

            while ((loc>0) && (theArray[loc-1]>temp)) {
                theArray[loc] = theArray[loc-1];
                loc=loc-1;
            }
            theArray[loc]=temp;
        }
    }

    public static void  complexityOfLists(){
        // Change to ArrayList to see linear complexity
        List<Integer> list1 = new LinkedList<>();
        int m=1000;
        int n=1000000;

        // Populate the list with n random integers
        Random randGenerator = new Random();
        for (int i=0; i<n; i++) {
            list1.add(randGenerator.nextInt());
        }

        // Call the add(0,item) method that adds at the front
        for (int i=0; i<10; i++) {
            long time = System.nanoTime();
            list1.add(0, 100);
            time = System.nanoTime() - time;
            System.out.println("It took " + time + " nanosecs to add the element.");
        }
    }


}
