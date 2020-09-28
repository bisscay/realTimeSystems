/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb_exercise1;
// import timer task library
// (a task that can be scheduled for one-time or repeated execution by a Timer)
import java.util.TimerTask;
//
import java.util.Timer;
/**
 * Class to represent a job of counting down from 10
 * Store value of counter
 * Print value to console every time task runs
 * @author Bissallah Ekele (19061498)
 * @date 24/02/2019 
 */
public class SimpleTask extends TimerTask
{
    // 2. initialize down counter
    private int counter = 10;
    // initialize timer
    private Timer newTimer = null;
    // Generic Constructor
    // Object creation with initialized timer 
    public SimpleTask(Timer initiatedTimer) { // :newTimer(initiatedTimer) ??
        // Variable must be stored when the cstr of SimpleTask runs
        // Variable stores a reference to Timer object to cancel after code execution
        this.newTimer =  initiatedTimer;
    }
    /**
     * 2.
     * tickle time method
     * assigns counter back to 10
     */
    SimpleTask nTask = null;
    public void tickleTimer() {
        // take counter to 10 
        counter = 10;
    }
    // variable to hold start time
    long startTime = 0;
    @Override
    // action to be performed by this timer task
    public void run() {
        // 3. Code in here runs everytime the timer expires (each task's period)
        // loop defines number of tasks
        // 8. prompt JVM to run garbage collection
        //System.gc();
        // print out value of counter 6. Include current time in millseconds
        if (counter == 10){
            // store start time
            startTime = System.currentTimeMillis();
        }
        // 3. console output when counter is 0
        if(counter == 0) {
            // store current time at counter 0
            long currentTime = System.currentTimeMillis();
            //System.out.println("Count is " +counter +" after " +(currentTime-startTime) +"ms");
            System.out.println("System Resets in: " +counter +" seconds");
            System.out.println("System Reset");
            // 4. Decreament counter when timer expires to initialize cancel's condition
            --counter;
            //newTimer.cancel();
            //this.cancel();
        }
        // to sensure system reset is printed after the delay at counter 0
        if (counter > 0) {
            // store current time of each counter
            long currentTime = System.currentTimeMillis();
            //System.out.println("Count is " +counter +" after " +(currentTime-startTime) +"ms");
            // 7. modifying console output
            System.out.println("System Resets in: " +counter +" seconds");
            // 4. Decreament counter when timer expires
            --counter;
        }
        // 5. stop timer & task when counter reaches 0
        // main runs parallel to task's tread
        // if cancel is not called, main will never stop execution
        // by default, an executing task thread is capable of keeping an appplication from terminating 
        // main reaches it's end after other threads
        // call cancel to terminate timer's task execution thread rapidly, so main can continue to end of program
        if(counter<0) {
            newTimer.cancel();
            this.cancel();
        }
    }
}
