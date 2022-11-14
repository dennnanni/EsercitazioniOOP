package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberCommandLine implements DrawNumberView {

    private DrawNumberController observer = null;

    public void setController(DrawNumberController observer) {
        this.observer = observer;
    }

    @Override
    public void start() {
        
    }

    @Override
    public void result(DrawResult res) {
        System.out.println("Result: " + res);
    }

}