package com.ua.potaychuk.cpu;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Potaychuk Sviatoslav on 28.06.2016.
 */
public class CPUQueue extends Thread{

    /**
     * It's a size of queue of processes
     */
    volatile int cpuProcesses;

    /**
     * Max size
     */
    public volatile int maxCpuProcesses;

    /**
     * There max size of queue will be identified
     */
    public void run(){
      while (true){
         if (maxCpuProcesses<=cpuProcesses){
            maxCpuProcesses=cpuProcesses;
         }
      }
    }
    synchronized void changeSize(Change action){
        if (action.equals(Change.ADD)) {
            cpuProcesses++;
        }else {
            cpuProcesses--;
        }
    }
    enum Change{
        ADD, SUB
    }
}
