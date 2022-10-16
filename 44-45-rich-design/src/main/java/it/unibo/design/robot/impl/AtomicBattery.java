package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotPart;

public class AtomicBattery extends RobotPart {

    private static final double POWER_CONSUMPTION = 0.3;

    public AtomicBattery() {
        super(POWER_CONSUMPTION);
    }

    @Override
    public void doAction() {
        // TODO Auto-generated method stub
        
    }
    
}
