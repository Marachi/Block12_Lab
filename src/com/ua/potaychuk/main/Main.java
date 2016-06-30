package com.ua.potaychuk.main;

import com.ua.potaychuk.mvc.Controller;
import com.ua.potaychuk.mvc.Model;
import com.ua.potaychuk.mvc.View;

/**
 * Created by Potaychuk Sviatoslav on 28.06.2016.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.processUser();




    }
}
