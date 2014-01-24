package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that pulls the shooter to goal position.
 * @author grr340
 */
public class ShooterPullToGoalPos extends CommandBase {
    
    /**
     * Constructor for the ShooterPullToGoalPos class.
     */
    public ShooterPullToGoalPos() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Pulls back the shooter.
     */
    protected void execute() {
        shooter.setRachetWinch(shooter.PULL_SPEED);
    }

    /**
     * Is finished when the shooter is down.
     * @return boolean
     */
    protected boolean isFinished() {
        return shooter.isArmDown();
    }

    /**
     * When finished it stops pulling.
     */
    protected void end() {
        shooter.stopRachetWinch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}