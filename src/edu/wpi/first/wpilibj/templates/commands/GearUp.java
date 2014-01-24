package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that shifts the gear up.
 * @author Tech
 */
public class GearUp extends CommandBase {

    /**
     * Constructor for the GearUp.
     */
    public GearUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(gearShift);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Method that shifts the robot into high gear. calls gearHigh.
     */
    protected void execute() {
        gearShift.gearHigh(); 
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