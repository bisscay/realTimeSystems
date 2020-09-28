
/**
 * Contains a set of methods to calculate simple mathematical operations.
 *
 * @author (Bissallah Ekele)
 * @student_id (19061498)
 * @version (20/02/2020)
 */

import java.util.*;

public class MyMath
{
    // instance variables for summation
    private static int num1 = 0;
    private static int num2 = 0;

    /**
     * Constructor for objects of class MyMath
     */
    public MyMath()
    {
            // Cstr
    }

    /**
     * derive the sum of two passed values
     * function overloading
     *
     * @param  num1,num2 values to be summed
     * @return    the sum of num1 and num2
     */
    public static int sum(int a, int b)
    {
        // initialize num1 & num2
        num1 = a; num2 = b;
        // return summation
        return num1 + num2;
    }
    
    /**
     * derive the sum of an N integer argument
     * function overloading
     * 
     * @param array list
     * @return sum of array index values
     */
    public static int sum(ArrayList<Integer>myArray)
    {
        // variable to store result of summation
        int sum = 0;
        // iterate through values in array
        for(int x : myArray) {
            // add up values
            sum += x;
        }
        return sum;
    }
    
    /**
     * get the minimum  of 3 arguments
     * function overloading
     * 
     * @param a,b,c values to be compared
     * @return minumum of 3
     */
    public static int min(int a, int b, int c)
    {
        // derive minimum
        // check if a is smalller
        if ((a<b)&&(a<c)) {
            return a;
        } else if (b<c) { // check if b is smaller
            return b;
        } else { // else c is smaller
            return c;
        }
    }
    
    /**
     * get the minimum of values in the array's index
     * function overloading
     * 
     * @param array of integers
     * @return minimum value in array
     */
    public static int min(ArrayList<Integer>myArray)
    {
       // Sort array
       Collections.sort(myArray);
       // return first value in array
       return myArray.get(0);
       
        /*
        // get first value in array
        int minValue = myArray.get(0);
        // loop through each value in array
        for (int i : myArray) {
            // check if current minimum value is greater than others
            if (minValue > i) {
                // if current minimum is greater, then current value is minimum
                minValue = i;
            }
        }
        return minValue;
        */
    }
    
    /**
     * derive duration of sum operation due to number of initializations
     * 
     * @param numOp number of operations
     * @return void
     */
    // pass in number of times sum operation is to be resolved
    public static void sumTimeSpan(int numOp)
    {
        // hole operation instance for console output
        int opCount = numOp;
        // timestamp at start of summation
        long startTime = System.currentTimeMillis();
        // summation called based on number of instantiation
        while(numOp > 0)
        {
            // call summation based on initialized sum parameters
            sum(num1,num2);
            // decreament operations to execute
            --numOp;
        }
        // timestamp end of operations
        long endTime = System.currentTimeMillis();
        // derive time duration
        long timeSpan = endTime - startTime;
        // output time duration
        System.out.println("For " +opCount +" operations;\nStart Time: " +startTime +"\nEnd Time: " +endTime +"\nFirst Number: " +num1 +"  Second Number: " +num2 +"\nDuration: " +timeSpan +" msec\n");
    }
}
