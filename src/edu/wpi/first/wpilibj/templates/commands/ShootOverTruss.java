package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that allows us to shoot the ball over the truss.
 * @author grr340
 */
public class ShootOverTruss extends CommandBase {
    
    /**
     * Constructor for the ShootOverTruss class.
     */
    public ShootOverTruss() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Pulls back the trigger.
     */
    protected void execute() {
        shooter.setRachetWinch(shooter.PULL_SPEED);
    }

    /**
     * Is finished when it is in the truss position.
     * @return boolean
     */
    protected boolean isFinished() {
        return shooter.getArmPosition() > shooter.TRUSS_POSITION;
    }

    /**
     * Shoots.
     */
    protected void end() {
        shooter.shoot();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}