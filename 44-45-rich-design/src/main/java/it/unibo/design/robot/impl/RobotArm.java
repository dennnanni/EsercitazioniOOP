package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.CommandableRobotPart;

public class RobotArm extends CommandableRobotPart {

    private static final double POWER_CONSUMPTION = 0.4;
    private static final String COMMAND_PICK_UP = "pick";
    private static final String COMMAND_DROP_DOWN = "drop";

    private BaseArm arm;
    private String commandSent;
 
    public RobotArm() {
        super(POWER_CONSUMPTION);
        this.arm = new BaseArm("Arm");
        this.commandSent = null;
    }

    public void doAction() {
        switch (this.commandSent) {
            case COMMAND_PICK_UP:
                if (!arm.isGrabbing()) {
                    arm.pickUp();
                }
                break;
            case COMMAND_DROP_DOWN:
                if (arm.isGrabbing()) {
                    arm.dropDown();
                }
                break;
            default:
                return;
        }

        this.commandSent = null;
    }

    public String[] availableCommands() {
        return new String[] {COMMAND_PICK_UP, COMMAND_DROP_DOWN};
    }

    public void sendCommand(final String command) {
        this.commandSent = command;
    }

    public String toString() {
        return "RobotArm";
    }
    
}
