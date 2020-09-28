package labc_exercise1;

import java.util.ArrayList;

/**
 *
 * @author Bissallah Ekele (19061498) 18/03/2020
 */
public class LabC_Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**
         * Given; T1 = (15,1,14)
         * T2 = (20,2,16)
         * T3 = (22,3,22)
         * 
         * Tn = (phi, P, e, D)
         * phi = phase
         * P = period
         * e = execution
         * D = relative deadline
         * @ default phi = 0, P = D
         */
        
        // create array to hold execution time (ei)
        ArrayList<Integer>execTime = new ArrayList();
        // add execution time to array
        execTime.add(1);
        execTime.add(2);
        execTime.add(3);
        // create array to hold period (Pi)
        ArrayList<Integer>period = new ArrayList();
        // add period to array
        period.add(15);
        period.add(20);
        period.add(22);
        // create array to hold relative deadline (Di)
        ArrayList<Integer>deadline = new ArrayList();
        // add deadline to array
        deadline.add(14);
        deadline.add(26);
        deadline.add(22);
        // Apply Rule 1
        Frames obj = new Frames();
        // hold result of Rule 1 in array 
        ArrayList<Integer>factorsR1 = obj.calculateRuleOne(execTime, period);
        // Test rule 1
        //System.out.println(factorsR1);
        // Test rule 2
        ArrayList<Integer>factorsR2 = obj.calculateRuleTwo(period,factorsR1);
        //System.out.println(factorsR2);
        // Test rule 3
        ArrayList<Integer>factorsR3 = obj.calculateRuleThree(period,factorsR2,deadline);
        System.out.print("Valid possible frame sizes: " );
        obj.printArray(factorsR3);
    }
    
}
