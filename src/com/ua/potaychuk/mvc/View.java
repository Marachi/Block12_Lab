package com.ua.potaychuk.mvc;

/**
 * Created by Potaychuk Sviatoslav on 28.06.2016.
 */
public class View {


    public static final String INPUT_DATA = "Input time in ms, please: ";
    public static final String INPUT_FROM = "From: ";
    public static final String INPUT_TO = "To: ";
    public static final String WRONG_INPUT_LONG_DATA = "Wrong input! Please, input LONG value: ";
    public static final String NOT_MINUS = "Wrong input! Please, input value more than 0: ";
    public static final String WRONG_TO = "Wrong data input! Please, input a number more than  ";
    public static final String CPU = "Input processing range of CPU:";
    public static final String PROCESS = "Input generating time range of processes:";
    public static final String TIME = "Input general time of CPU work:";
    public static final String PROCESS_GENERATED = "New process in queue!";
    public static final String PROCESS_REMOVED = "Process is removed!";
    public static final String SIZE_QUEUE = "Queue size: ";


    /**
     *Print methods
     */
    public void printQueueValue(int l){
        System.out.println("Max queue size: " + l);
    }
    public void printMsg(String msg){
        System.out.println(msg);
    }
    public void printMsgL(String msg){
        System.out.print(msg);
    }
    public void printMsgAndLong(String s, long l){
        System.out.println(s+l);
    }

}
