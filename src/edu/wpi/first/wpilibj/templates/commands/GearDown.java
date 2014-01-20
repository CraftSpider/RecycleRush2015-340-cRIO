package edu.wpi.first.wpilibj.templates.commands;

/**
 * Commands that shifts gears down.
 * @author Tech
 */
public class GearDown extends CommandBase {

    /**
     * Constructor for the GearDown class.
     */
    public GearDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(gearShift);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Method that shifts the gear down.
     */
    protected void execute() {
        gearShift.gearLow(); //shift the robot into low gear. calls gearLow.
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}