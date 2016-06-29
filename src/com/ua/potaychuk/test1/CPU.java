package com.ua.potaychuk.test1;

/**
 * Created by Славик on 28.06.2016.
 */
public class CPU extends Thread{

    CPUQueue cpuQueue;

    public CPU(CPUQueue cpuQueue) {
        this.cpuQueue = cpuQueue;
    }

    public CPU() {
        this(new CPUQueue());
    }

    public void run(){
       for (;;)
           if (cpuQueue.cpuProcesses.size()!=0){
           long generateTime = (long) (Math.random()*1000);
           System.out.println("QUEUE SIZE: "+cpuQueue.cpuProcesses.size()+ "Process in CPU!!! Time to serve it: "+generateTime);
           try {
               this.sleep(generateTime);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

    }



}
