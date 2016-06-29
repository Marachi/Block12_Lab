package com.ua.potaychuk.test1;

/**
 * Created by Славик on 28.06.2016.
 */
public class CPUProcess extends Thread {

    CPUQueue cpuQueue;

    public CPUProcess(CPUQueue cpuQueue) {
        this.cpuQueue = cpuQueue;
    }

    public void run(){
        long generateTime = (long) (Math.random()*1000);
        System.out.println("Time: "+ generateTime);
        try {
            this.sleep(generateTime);
            cpuQueue.cpuProcesses.add(new CPUProcess(cpuQueue));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END!");
    }
}
