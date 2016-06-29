package com.ua.potaychuk;

import com.ua.potaychuk.test1.CPU;
import com.ua.potaychuk.test1.CPUProcess;
import com.ua.potaychuk.test1.CPUQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        CPUQueue cpuQueue = new CPUQueue();
        Thread t1 =  new CPUProcess(cpuQueue);
        t1.start();
        CPU cpu = new CPU(cpuQueue);
        cpu.start();


    }
}
