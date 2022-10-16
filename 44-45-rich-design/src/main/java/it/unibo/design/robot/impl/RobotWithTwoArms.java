package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotWithArms;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {

    private final double ADDITIONAL_CONSUMPTION = 0.1;

    private final BaseArm armDx;
    private final BaseArm armSx;
    private int carriedItemsCount;

    public RobotWithTwoArms(final String robotName) {
        super(robotName);
        this.armDx = new BaseArm("Right side");
        this.armSx = new BaseArm("Left side");
        this.carriedItemsCount = 0;
    }

    public boolean pickUp() {
        BaseArm executingArm = null;
        if (canPickUp(this.armDx)) {
            executingArm = this.armDx;
        }
        else if (canPickUp(this.armSx)) {
            executingArm = this.armSx;
        }

        if (executingArm == null) {
            return false;
        }

        executingArm.pickUp();
        this.carriedItemsCount++;
        consumeBattery(executingArm.getConsuptionForPickUp());

        return true;
    }

    private boolean canPickUp(final BaseArm arm) {
        return !arm.isGrabbing() && isBatteryEnough(arm.getConsuptionForPickUp());
    }

    public boolean dropDown() {
        BaseArm executingArm = null;
        if (canDropDown(this.armDx)) {
            executingArm = this.armDx;
        }
        else if (canDropDown(this.armSx)) {
            executingArm = this.armSx;
        }

        if(executingArm == null) {
            return false;
        }

        executingArm.dropDown();
        this.carriedItemsCount--;
        consumeBattery(executingArm.getConsumptionForDropDown());

        return true;
    }

    private boolean canDropDown(final BaseArm arm) {
        return arm.isGrabbing() && isBatteryEnough(arm.getConsumptionForDropDown());
    }

    public int getCarriedItemsCount() {
        return this.carriedItemsCount;
    }

    public double getBatteryRequirementForMovement() {
        double consumption = super.getBatteryRequirementForMovement();
        
        if (armDx.isGrabbing()) {
            consumption += ADDITIONAL_CONSUMPTION;
        }

        if (armSx.isGrabbing()) {
            consumption += ADDITIONAL_CONSUMPTION;
        }

        return consumption;
    }
}