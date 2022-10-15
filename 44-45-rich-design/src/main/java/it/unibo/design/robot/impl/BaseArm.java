package it.unibo.design.robot.impl;

public class BaseArm {

    private static final double CONSUMPTION_PICK_UP = 1;
    private static final double CONSUMPTION_DROP_DOWN = 0.5;

    private boolean isGrabbing;

    public BaseArm(final String something) {

    }

    public boolean isGrabbing() {
        return this.isGrabbing;
    }

    public void pickUp() {
        this.isGrabbing = true;
    }

    public void dropDown() {
        this.isGrabbing = false;
    }

    public double getConsuptionForPickUp() {
        return CONSUMPTION_PICK_UP;
    }

    public double getConsumptionForDropDown() {
        return CONSUMPTION_DROP_DOWN;
    }
}