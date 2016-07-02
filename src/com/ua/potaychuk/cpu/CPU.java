package com.ua.potaychuk.cpu;

import com.ua.potaychuk.mvc.View;

/**
 * Created by Potaychuk Sviatoslav on 28.06.2016.
 */
public class CPU extends Thread{

    /**
     * Low time border of treatment process
     */
    private long from;

    /**
     * Top time border of processing process
     */
    private long to;


    /**
     * Queue of processes
     */
    private CPUQueue queue;

    /**
     * Constructor
     * @param queue
     */
    public CPU(CPUQueue queue) {
        this.queue = queue;
    }
    /**
     * In this thread processes in queue will be finished and removed from queue
     */
    public void run(){
        while (!interrupted()) {
           if (queue.cpuProcesses != 0) {                    //checking for process in queue
               long generateTime = (long) (from+Math.random() * (to-from+1)); //time range of processing process
               try {
                   this.sleep(generateTime);                        //processing
                   queue.changeSize(CPUQueue.Change.SUB);        //remove process from queue
                   System.out.println(View.PROCESS_REMOVED + " "+ View.SIZE_QUEUE + queue.cpuProcesses);
               } catch (InterruptedException e) {
//                   e.printStackTrace();
                   interrupt();
               }
           }
       }

    }


    //getters & setters
    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }
}
