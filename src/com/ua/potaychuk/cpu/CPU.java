package com.ua.potaychuk.cpu;

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
     * In this thread processes in queue will be finished and removed from queue
     */
    public void run(){
        while (!interrupted()) {
           if (CPUQueue.cpuProcesses != 0) {                    //checking for process in queue
               long generateTime = (long) (from+Math.random() * (to-from+1)); //time range of processing process
               try {
                   this.sleep(generateTime);                        //processing
                   CPUQueue.changeSize(CPUQueue.Change.SUB);        //remove process from queue
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
