package it.unibo.design.robot.api;

public abstract class RobotPart {

    private boolean isOn;
    private final double powerConsumption;
    private boolean isConnected;

    public RobotPart(final double powerConsumption) {
        this.powerConsumption = powerConsumption;
        this.isOn = false;
        this.isConnected = false;
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

    public boolean isConnected() {
        return this.isConnected;
    }

    public void connect() {
        this.isConnected = true;
    }

    public void disconnect() {
        this.isConnected = false;
    }

    public abstract void doAction();
}