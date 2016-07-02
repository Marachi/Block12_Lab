package com.ua.potaychuk.mvc;

import com.ua.potaychuk.cpu.CPU;
import com.ua.potaychuk.cpu.CPUProcess;
import com.ua.potaychuk.cpu.CPUQueue;

/**
 * Created by Potaychuk Sviatoslav on 28.06.2016.
 */
public class Model {

    /**
     * CPU
     */
    private CPU cpu;

    /**
     * Process
     */
    private CPUProcess cpuProcess;

    /**
     * Queue of processes
     */
    private CPUQueue cpuQueue;

    public Model() {
        cpuQueue = new CPUQueue();
        cpu = new CPU(cpuQueue);
        cpuProcess = new CPUProcess(cpuQueue);
    }

    /**
     * This method begins threads for uncertain range of time
     */
    void startWork(){
        cpuQueue.setDaemon(true);
        cpuQueue.start();
        cpuProcess.start();
        cpu.start();
    }

    /**
     *This method begins work of cpu for certain time range
     * @param time is time range
     */
    void startWork(long time){
        cpuQueue.setDaemon(true);
        cpuQueue.start();
        cpuProcess.start();
        cpu.start();
        try {
            Thread.sleep(time);
            cpuProcess.interrupt();
            cpu.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method return max size of queue of processes
     * @return
     */
    int getMaxQueueSize(){
        return cpuQueue.maxCpuProcesses;
    }

    /**
     * This method sets range of time to treatment processes
     * @param from is low border of time range
     * @param to is top border of time range
     */
    void setTimeRangeCpu(long from, long to){
     cpu.setFrom(from);
     cpu.setTo(to);
     }

    /**
     * This method sets range of time to generate processes
     * @param from is low border of time range
     * @param to is top border of time range
     */
    void setTimeRangeProcess(long from, long to){
        cpuProcess.setFrom(from);
        cpuProcess.setTo(to);
    }


    //getters & setters
    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public CPUProcess getCpuProcess() {
        return cpuProcess;
    }

    public void setCpuProcess(CPUProcess cpuProcess) {
        this.cpuProcess = cpuProcess;
    }
}
