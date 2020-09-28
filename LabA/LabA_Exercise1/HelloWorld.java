
/**
 * Write a description of class HelloWorld here.
 *
 * @author (Bissallah Ekele)
 * @id (19061498)
 * @version (1.0)
 * @date (17/02/2020)
 */
public class HelloWorld
{
    // initialize down counter variables
    private int count = 0;
    
    /**
     * Default Constructor for objects of class HelloWorld
     */
    public HelloWorld()
    {
        System.out.println("\nHello World!");
    }
    
    /**
     * Generic Constructor for objects of class HelloWorld
     */
    public HelloWorld(int count)
    {
        // Call the printHelloWorld method
        printHelloWorld(count);
    }

    /**
     * Print hello world to the console
     *
     * @param  null
     * @return  void
     */
    public void printHelloWorld(int count)
    {
        // store amount to be printed
        int amount = count;
        // store the current time in relation to the current time
        // and midnight, January 1, 1970 in milliseconds
        // store time before loop
        long startTime = System.currentTimeMillis();
        // loop 4 thousand times
        while (count > 0) // loop while true
        {
            // console out hello world
            System.out.println("Hello World!");
            // decreament counter
            --count;
        }
        // store time after loop
        long endTime = System.currentTimeMillis();
        // find difference
        long difference = endTime - startTime;
        // State amount printed
        System.out.println("\nFor " +amount +" Welcome Messages.");
        System.out.println("Start Time: " +startTime +" msec");
        System.out.println("End Time: " +endTime +" msec");
        System.out.println("Difference: " +difference +" msec");
    }
}
