/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb_exercise1;
// import timer library
import java.util.Timer;
// import timertask library
//import java.util.TimerTask;
/**
 * This class will be the entry point for the program
 * It will create a timer, create a task and 
 * schedule the timer to run at some point in the future
 * Instance runs each time the timer expires
 * Setup a repeating timer
 * Period = 1 second
 * Release time = 2 seconds
 * @author Bissallah Ekele (19061498)
 * @date 24/02/2020
 */
public class SimpleTimer {
    // Timer task (SimpleTask obj) to run once scheduled period elapses
    // initialize period
    private static int period = 1000; // milliseconds
    // initialize release time
    private static int releaseTime = 2000; // milliseconds
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Timer Main");
        // Initialize timer
        Timer timer = new Timer();
        // Generate timer task(job) for timer
        // (1. Variable to store reference to Timer object)
        // Variable must be stored when the cstr of SimpleTask runs
        SimpleTask taskToRun = new SimpleTask(timer);
        // launch JFrame class once timer has been initialized
        // Initialise a graphical window
        WatchDogFrame watchdogFrame = new WatchDogFrame(taskToRun);
        // Display the window
        watchdogFrame.setVisible(true);
        // Schedule job to run every 1 second, with an initial delay of 2 seconds
        // schedule(TimerTask task, long delay, long period)
        // Note each executing task will run for the period specified hugging the processor even after actual execution of job
        // Completion time in effect, potentially happens way before relative & absolute deadline 
        timer.schedule(taskToRun, releaseTime, period);
    }
}
/**
 * 8. Task run times change because the garbage collection causes a delay 
 * Pros of garbage collection are seen in the long run where frq of exec is generally lower
 * Short run tasks are used for recurring activities that require smoothness (animation tasks)
 * 
 * Timer Main (No Garbage Collection)
Count is 10 after 1583150275149ms
Count is 9 after 1583150275149ms
Count is 8 after 1583150275149ms
Count is 7 after 1583150275149ms
Count is 6 after 1583150275149ms
Count is 5 after 1583150275149ms
Count is 4 after 1583150275149ms
Count is 3 after 1583150275150ms
Count is 2 after 1583150275150ms
Count is 1 after 1583150275150ms
BUILD SUCCESSFUL (total time: 2 seconds)
* 
* Timer Main (With Garbage Collection)
Count is 10 after 1583150321701ms
Count is 9 after 1583150321708ms
Count is 8 after 1583150321712ms
Count is 7 after 1583150321717ms
Count is 6 after 1583150321723ms
Count is 5 after 1583150321728ms
Count is 4 after 1583150321732ms
Count is 3 after 1583150321737ms
Count is 2 after 1583150321743ms
Count is 1 after 1583150321747ms
BUILD SUCCESSFUL (total time: 2 seconds)
 */
