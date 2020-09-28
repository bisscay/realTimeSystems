
/**
 * Contains main method to test methods in the MyMath class.
 * Methods of MyMath must be static, 
 * hence one can call the methods without creating objects of MyMath
 *
 * @author (Bissallah Ekele)
 * @student_id (19061498)
 * @version (20/02/2020)
 */
// import ArrayList class impementation of list interface
import java.util.ArrayList;

public class MyMathTest
{
    // Main method to test methods of MyMath class
    public static void main(String[] args)
    {
        // pass in values to be summed by sum method
       System.out.println("Integer Sum: " +MyMath.sum(10,11));
       // create array
       ArrayList<Integer>testArray = new ArrayList();
       // add test values
       testArray.add(1);
       testArray.add(23);
       testArray.add(7);
       // pass array to be index value summed and print result
       System.out.println("\nArray Sum: " +MyMath.sum(testArray));
       // find minimum value of three integers
       System.out.println("\nMinimum Integer Value: " +MyMath.min(23,44,16));
       // find minimum value in test aray
       System.out.println("\nMinimum Aray Value: " +MyMath.min(testArray) +"\n");
       // Estimate time for 1000 operations
       MyMath.sumTimeSpan(1000);
       // Estimate time for 10000 operations
       MyMath.sumTimeSpan(10000);
       // Estimate time for 100000 operations
       MyMath.sumTimeSpan(100000);
       // Estimate time for 1000000 operations
       MyMath.sumTimeSpan(1000000);
    }
}
