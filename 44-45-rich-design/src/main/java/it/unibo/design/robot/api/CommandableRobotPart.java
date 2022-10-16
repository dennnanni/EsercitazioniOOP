package it.unibo.design.robot.api;

public abstract class CommandableRobotPart extends RobotPart {

    public CommandableRobotPart(final double powerConsumption) {
        super(powerConsumption);
    }

    public abstract String[] availableCommands();

    public abstract void sendCommand(final String command);
    
}
