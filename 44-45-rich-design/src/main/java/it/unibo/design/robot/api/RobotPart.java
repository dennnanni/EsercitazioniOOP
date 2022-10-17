package it.unibo.design.robot.api;

public abstract class RobotPart {

    private boolean isOn;
    private final double powerConsumption;
    private ComposableRobot robot;

    public RobotPart(final double powerConsumption) {
        this.powerConsumption = powerConsumption;
        this.isOn = false;
    }

    public double getPowerConsumption() {
        return this.powerConsumption;
    }

    public boolean isTurnedOn() {
        return this.isOn;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public void connect(final ComposableRobot robot) {
        this.robot = robot;
    }

    public void disconnect(final ComposableRobot robot) {
        this.robot = null;
    }

    public ComposableRobot getRobot() {
        return this.robot;
    }

    public boolean isPlugged() {
        return this.robot != null;
    }

    public abstract void doAction();
}