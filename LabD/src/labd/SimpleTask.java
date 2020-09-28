/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labd;

/**
 *
 * @author Bissallah Ekele (19061498) 30/03/2020
 */
public class SimpleTask {
    // private variables
    int releaseTime = 0;
    int execTime = 0;
    int taskID = 0;
    // counter for time
    double time = 0.0;
    /**
     * Default Cstr
     */
    public SimpleTask() {
        // Cstr
    }
    /** 
     * Generic Cstr
     * @param releaseTime
     * @param execTime
     * @param taskID 
     */
    public SimpleTask(int releaseTime, int execTime, int taskID) {
        // storing as instance variables
        this.releaseTime = releaseTime;
        this.execTime = execTime;
        this.taskID = taskID;
    }
    /**
     * Console current task running
     */
    public void doTask() {
        System.out.println("Time: " +time +" T" +taskID 
                +" runs with execution time " +execTime);
    }
    /**
     * Get time
     * @return time
     */
    public double getTime() {
        return time;
    }
    /**
     * Set time
     * @param time 
     */
    public void setTime(double time) {
        this.time = time;
    }
    /**
     * Get release time
     * @return release time
     */
    public int getReleaseTime() {
        return releaseTime;
    }
    /**
     * Set release time
     * @param releaseTime 
     */
    public void setReleaseTime(int releaseTime) {
        this.releaseTime = releaseTime;
    }
    /**
     * Get execution time
     * @return 
     */
    public int getExecTime() {
        return execTime;
    }
    /**
     * Set execution time
     * @param execTime 
     */
    public void setExecTime(int execTime) {
        this.execTime = execTime;
    }
    @Override
    public String toString() {
        return "\nT" +taskID +": Release Time: " +releaseTime 
                +".0 Exec Time: " +execTime +".0";
    }
}
