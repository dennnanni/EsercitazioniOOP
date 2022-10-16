package it.unibo.design.robot.api;

import it.unibo.design.robot.impl.BaseRobot;

public abstract class ComposableRobot extends BaseRobot {

    private static final int MAX_PARTS = 5;

    private RobotPart[] components;
    private int attachedComponentsCount;

    public ComposableRobot(final String robotName) {
        super(robotName);
        this.components = new RobotPart[MAX_PARTS];
        this.attachedComponentsCount = 0;
    }

    public void attachComponent(final RobotPart component) {
        component.connect();

        this.components[this.attachedComponentsCount] = component;
        this.attachedComponentsCount++;
    }

    public void detachComponent(final RobotPart component) {
        component.disconnect();

        boolean deleted = false;
        for (int i = 0; i < attachedComponentsCount; i++) {
            if (this.components[i] == component) {
                this.components[i] = null;
                deleted = true;
            }
            else if (deleted) {
                this.components[i - 1] = this.components[i];
            }
        }

        if (deleted) {
            this.attachedComponentsCount--;
        }
    }

    public void doCycle() {
        for(var component: this.components) {
            if (component.isTurnedOn() && isBatteryEnough(component.getPowerConsumption())) {
                component.doAction();
                consumeBattery(component.getPowerConsumption());
            }
        }
    }

}