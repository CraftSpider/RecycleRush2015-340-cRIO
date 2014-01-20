package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that stops the roller if a ball is present.
 * @author tech
 */
public class StopRollersIfBallPresent extends CommandBase {
    
    /**
     * Constructor for the StopRollersIfBallPresent class.
     */
    public StopRollersIfBallPresent() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
    }

    /**
     * Turns rollers on.
     */
    protected void initialize() {
        ballIntake.ballIntakeRollerIn(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    /**
     * Is finished when ball is in the mechanism.
     * @return boolean
     */
    protected boolean isFinished() {
        return ballIntake.isBallInMechanism();
    }

    /**
     * When finished, stops the roller.
     */
    protected void end() {
        ballIntake.ballIntakeRollerStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}