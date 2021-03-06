package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 */
public class MO_FourBarClawOpen extends CommandBase {

    public MO_FourBarClawOpen() {
		requires(fourBar);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	fourBar.openClaw();
    	System.out.println("[MO_FourBarClawOpen: initialize] opens the claw");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	fourBar.openClaw();
    	System.out.println("[MO_FourBarClawOpen: execute] opens the claw");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[MO_FourBarClawOpen: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[MO_FourBarClawOpen: interrupted] called");
    }
}
