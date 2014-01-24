package edu.wpi.first.wpilibj.templates.commands;

/**
 * Sets ball intake to load position.
 * @author tech
 */
public class BallIntakeGoToLoadPosition extends CommandBase {
    
    /**
     * Constructor for the BallIntakeGoToLoadPosition class.
     */
    public BallIntakeGoToLoadPosition() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Deploys intake.
     */
    protected void execute() {
        ballIntake.deployIntake();
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
