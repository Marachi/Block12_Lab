package com.ua.potaychuk.mvc;

import java.util.Scanner;

/**
 * Created by Potaychuk Sviatoslav on 28.06.2016.
 */
public class Controller {

    /**
     * Model
     */
    private Model model;

    /**
     * View
     */
    private View view;

    /**
     * An necessary variable for valid time range input
     */
    private long from;

    /**
     * Constructor
     * @param model is Model
     * @param view is View
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * This method starts work and shows max size of queue
     */
    public void processUser(){

        /*setting processing time range*/
        view.printMsg(View.CPU);
        model.setTimeRangeCpu(inputTwoValueWithScanner(new Scanner(System.in)),
                inputTwoValueWithScanner(new Scanner(System.in)));

        /*setting generating time range*/
        view.printMsg(View.PROCESS);
        model.setTimeRangeProcess(inputTwoValueWithScanner(new Scanner(System.in)),
                inputTwoValueWithScanner(new Scanner(System.in)));

        /*setting time of work*/
        view.printMsg(View.TIME);

        /*Start*/
        model.startWork(inputOneValueWithScanner(new Scanner(System.in)));

        /*View a max size of queue*/
        view.printQueueValue(model.getMaxQueueSize());
    }

    /**
     * This method returns a valid range values
     * @param sc is Scanner
     * @return valid range border
     */
    private long inputTwoValueWithScanner(Scanner sc) {

        if(from ==0) {                    //bottom border
            view.printMsg(View.INPUT_DATA);
            view.printMsg(View.INPUT_FROM);
        }else {                                 //top border
            view.printMsg(View.INPUT_TO);
        }

        //save data in temporary variable a
        long a = inputOneValueWithScanner(sc);

        /*setting bottom price value*/
        if (from ==0){
            /*valid input*/
            if (a >= 0) {
                return  from =a; //set new bottom value and return it
            }/*invalid input*/else {
                view.printMsg(View.NOT_MINUS);
                return  inputTwoValueWithScanner(sc);       //recursive method invocation
            }
        } /*setting top price value*/ else {
            /*valid input*/
            if (a>= from){
                from =0;      //clear bottom value
                return a;           //return valid data
            } /*invalid input*/ else {
                view.printMsgAndLong(View.WRONG_TO, from);
                return inputTwoValueWithScanner(sc);        //recursive method invocation
            }
        }

    }

    /**
     * This method returns a valid long value
     * @param sc is Scanner
     * @return valid range border
     */
    private long inputOneValueWithScanner(Scanner sc) {
        /*there input data is checked for valid type (expected is long)*/
        while (!sc.hasNextLong()) {
            view.printMsg(View.WRONG_INPUT_LONG_DATA);
            view.printMsg(View.INPUT_DATA);
            if(from ==0){                 //bottom border
                view.printMsgL(View.INPUT_FROM);
            }else {                             //top border
                view.printMsgL(View.INPUT_TO);
            }
            sc.next();
        }
        return sc.nextLong();
    }

}
