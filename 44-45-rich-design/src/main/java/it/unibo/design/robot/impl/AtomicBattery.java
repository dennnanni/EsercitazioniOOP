package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotPart;

public class AtomicBattery extends RobotPart {

    private static final double POWER_CONSUMPTION = 0;

    public AtomicBattery() {
        super(POWER_CONSUMPTION);
    }

    public void doAction() {
        getRobot().recharge();
    }

    public String toString() {
        return "Atomic battery";
    }
}
