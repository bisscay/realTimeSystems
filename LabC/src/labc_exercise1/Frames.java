package labc_exercise1;

import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Bissallah Ekele (19061498) 18/03/2020
 * Class to compute the three frame size constraints rules
 */
public class Frames {
    // f >= max(ei) for all i
    // param: int[], int[] - arrays of execution time & period
    // return: int[] - factors of Pi(frames) grater than max exec time
    public ArrayList<Integer> calculateRuleOne(ArrayList newExecT, ArrayList newPeriodicTasks){
        ArrayList<Integer>factors = new ArrayList();
        // Find max e for all i
        int maxE = calculateMax(newExecT);
        // calculate hyperperiod, H = LCM(Pi)
        int H = calculateLCM(newPeriodicTasks);
        // factors of H starting from maxE till largest period
        for(int i = maxE; i <= calculateMax(newPeriodicTasks); ++i) {
            if(H%i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
    // [pi/f]-pi/f = 0 for at least one Pi
    // parm: int[], int[] - arrays of period & return value of rule 1
    // return: int[] - factors that pass rule 2
    public ArrayList<Integer> calculateRuleTwo(ArrayList<Integer> periodicTasks, ArrayList<Integer> factors){
        // Array to hold factors that pass rule 2
        ArrayList<Integer> result = new ArrayList();
        // pick a factor
        factors.forEach((f) -> {
            // check each period 
            for(int p : periodicTasks) {
                // check condition floor(p/f)-p/f == 0
                // & condition that only one instance of factor exists in result set
                if(((p/f - (float)p/f) == 0)&&!(result.contains(f))) {
                    result.add(f);
                }
            }
        });
        return result;
    }
    // 2f - gcd(pi,f) <= Di
    // 0 <= Di - (2f-gcd(Pi,f))
    public ArrayList<Integer> calculateRuleThree(ArrayList<Integer> periodicTasks, ArrayList<Integer> factors, ArrayList<Integer> relativeDeadline) {
        // Array to hold frame sizes that pass rule 3
        // initialize counter for number of tasks
        int count = 0;
        ArrayList<Integer> result = new ArrayList();
        // Pick a factor
        for(int f : factors) {
            // check each period & deadline at an index based on rule
            for(int i = 0; i < periodicTasks.size(); ++i) {
                if (0 <= (relativeDeadline.get(i)-(2*f - calculateGCD(relativeDeadline.get(i), f)))) {
                    ++count;
                }
            }
            // condition must be true for all tasks
            if (count == periodicTasks.size()) {
                result.add(f);
                // take task count back to zero
                count *= 0;
            }
        }
        return result;
    }
    // calculate largest number in an array
    public int calculateMax(ArrayList<Integer> newNumbers){
        // sort array in decending order
        Collections.sort(newNumbers, Collections.reverseOrder());
        // pick value in first index
        return newNumbers.get(0);
    }
    // gcd(pi,f)
    // GCD of two numbers using Euclid's method
    public int calculateGCD(int num1, int num2){
        // if divisor is zero, GCD = dividend
        if(num2 == 0) {
            return num1;
        }
        // Apply recursively
        return calculateGCD(num2, num1%num2);
    }
    // GCD of multiple numbers
    public int calculateGCD(ArrayList<Integer>numbers) {
        // GCD(a1,a2,a3,...,aN) = GCD(GCD(a1,a2),a3,...,aN)
        // get first element
        int result = numbers.get(0);
        for(int i=1 ; i < numbers.size(); ++i) {
            // update result
            result = calculateGCD(result,numbers.get(i));
        }
        return result;
    }
    // lcm(a,b)
    public int calculateLCM(ArrayList<Integer>numbers){
        // LCM(a1,a2,a3,...,aN) = LCM(LCM(a1,a2),a3,...,aN)
        // get first element
        int result = numbers.get(0);
        for(int i=1 ; i < numbers.size(); ++i) {
            // update result
            // LCM(a,b) = |a*b|/GCD(a,b)
            result = Math.abs(result*numbers.get(i))/calculateGCD(result,numbers.get(i));
        }
        return result;
    }
    // printArray(data, size)
    // param: int data[] - array of values
    //        int size - size of array field
    // return: void - the values in the array
    public void printArray(ArrayList<Integer> data) {
      System.out.print("{ ");                                                  
      for (int i = 0; i < data.size(); i++) {
        // separate each value by "," unless at last variable
        if (i+1 == data.size()) {
          System.out.print(data.get(i));
        } else {
          System.out.print(data.get(i) +", ");
        }
      }
      System.out.println(" }\n");
    }
}
