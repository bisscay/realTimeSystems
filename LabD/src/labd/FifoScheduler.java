/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Random;

/**
 *
 * @author Bissallah Ekele (19061498) 30/03/2020
 * [T1 ... T(N-1)]
 * TN = (rT, eT, tID)
 */
public class FifoScheduler implements Comparator<SimpleTask> {
    // private vairables
    // system start time
    int sysTime = 0;
    // time span to run task
    int timeSpan = 0;
    // Task queue
    private ArrayList<SimpleTask> taskQueue = new ArrayList();
    // Ready queue
    private ArrayList<SimpleTask> readyQueue = new ArrayList();
    
    /**
     * Update system time
     */
    public void updateSysTime() {
        // increament each task's time
        // create iterator for queue
        ListIterator lit = taskQueue.listIterator();
        // container holding temporary tasks
        SimpleTask t = null;
        // access task queue
        while(lit.hasNext()) {
            // initialize temp task
            t = (SimpleTask)lit.next();
            // update time
            timeSpan += t.getExecTime();
        }
    }
    /**
     * Create random tasks
     * 
     * @param size - Specify required number of tasks - Real N
     */
    public void createRandomTasks(int size) {
        // ensure size is Real
        if(size <= 0)
            size = 1;
        // task ID
        int taskID = 0;
        // Random number generator
        Random generator = new Random();
        // Random number containers
        int rand1 = 0;
        int rand2 = 0;
        // fill result with random tasks based on desired size
        while(size > 0) {
            rand1 = generator.nextInt(10);
            rand2 = generator.nextInt(10);
            // ensure random number starts from 1
            taskQueue.add(new SimpleTask(++rand1, ++rand2, taskID));
            --size;
            ++taskID;
        }
    }
    /**
     * Update system time & Copy job from task queue
     * Tasks with earlier release time will be in front on ready queue
     * Hence sort tasks based on release time on ready queue
     */
    public void updateReadyQueue() {
        // sort task queue
        Collections.sort(taskQueue, new FifoScheduler());
        // create iterator for queue
        ListIterator lit = taskQueue.listIterator();
        // container holding temporary tasks
        SimpleTask t = null;
        // access task queue
        while(lit.hasNext()) {
            // initialize temp task
            t = (SimpleTask)lit.next();
            // if task is ready to run & has not been added to ready queue
            if((t.getReleaseTime() <= sysTime)&&!(readyQueue.contains(t))) {
                // copy from taskQ to readyQ
                readyQueue.add(t);
                // update system time to span up to latest released task exec
                updateSysTime();
            }
        }
    }
    /**
     * Run exercise
     */
    public void runFIFO() {
        while(readyQueue.size() < taskQueue.size()) {
            ++sysTime;
            // update queue when task is ready
            updateReadyQueue();
            // create iterator for queue
            ListIterator lit = readyQueue.listIterator();
            // container holding temporary tasks
            SimpleTask t = null;
            // run if ready queue is empty
            if(!lit.hasNext()) { // derive a better condition for this
                // print "Nothing to run"
                System.out.println("Time: " +sysTime  
                        +".0 Nothing to run!");
            }
            // if task is in ready queue
            while(lit.hasNext()) {
                t = (SimpleTask)lit.next();
                // print until exec time = 0, 
                while(t.getExecTime() > 0) {
                    // update task system time
                    t.setTime(sysTime);
                    sysTime += 1.0;
                    // perform task
                    t.doTask();
                    // update execution time
                    int newExecTime = t.getExecTime() - 1;
                    t.setExecTime(newExecTime);
                }
                // run if no task to process
                if(!(t.getTime() == sysTime+1) && !(lit.hasNext()))
                    // print "Nothing to run"
                    System.out.println("Time: " +sysTime  
                            +".0 Nothing to run!");
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Title
        System.out.println("Tasks created with following params:");
        // Demacation
        System.out.println("-----------------------------------------");
        FifoScheduler sdl = new FifoScheduler();
        // put tasks on queue
        sdl.createRandomTasks(5);
        // console tasks to be scheduled
        System.out.println(sdl.taskQueue);
        // Demacation
        System.out.println("-----------------------------------------");
        // run scheduling algorithm
        sdl.runFIFO();
    }
    @Override
    public int compare(SimpleTask o1, SimpleTask o2) {
        return o1.getReleaseTime()-o2.getReleaseTime();
    }
}
