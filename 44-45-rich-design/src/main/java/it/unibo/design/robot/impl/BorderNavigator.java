package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotPart;

public class BorderNavigator extends RobotPart {

    private static final double POWER_CONSUMPTION = 0.5;
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;

    private int direction;

    public BorderNavigator() {
        super(POWER_CONSUMPTION);
        this.direction = 0;
    }

    protected boolean performMovement() {
        switch (this.direction) {
            case NORTH:
                return getRobot().moveUp();
            case EAST:
                return getRobot().moveRight();
            case SOUTH:
                return getRobot().moveDown();
            case WEST:
                return getRobot().moveLeft();
            default:
                return false;
        }
    }

    public void doAction() {
        int steps = 0;

        while (getRobot().isBatteryEnough(getRobot().getBatteryRequirementForMovement()) && performMovement()) 
        { 
            steps++;
        }

        getRobot().consumeBattery(steps * getRobot().getBatteryRequirementForMovement());
        
        this.direction++;
        if (this.direction > WEST) {
            this.direction = 0;
        }
    }
}