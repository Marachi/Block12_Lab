package com.ua.potaychuk.cpu;

import com.ua.potaychuk.mvc.View;

/**
 * Created by Potaychuk Sviatoslav on 28.06.2016.
 */
public class CPUProcess extends Thread {

    /**
     * Low time border of generating process
     */
    private long from;

    /**
     * Top time border of generating process
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
    public CPUProcess(CPUQueue queue) {
        this.queue = queue;
    }

    /**
     * In this thread new processes will be generated and added to queue
     */
    public void run() {

        while (!interrupted()) {
            long generateTime = (long) (from+Math.random() * (to-from+1));       //time range to generate new process
            try {
                queue.changeSize(CPUQueue.Change.ADD);                        //add to queue
                System.out.println(View.PROCESS_GENERATED);
                this.sleep(generateTime);                                        //wait for next generation
            } catch (InterruptedException e) {
//                e.printStackTrace();
                interrupt();
            }
//            System.out.println("END!");
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
