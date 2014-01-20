package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that shoots when the ball is present.
 * @author grr340
 */
public class ShootWhenBallPresent extends CommandBase {
    
    /**
     * Constructor for ShootWhenBallPresent class.
     */
    public ShootWhenBallPresent() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
        requires(ballIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Shoots when there is a ball in the mechanism.
     */
    protected void execute() {
        if(ballIntake.isBallInMechanism()){
            //same code can be used with a detector for if the ball is settled
            //TODO: timeout
            shooter.shoot();
        }
    }

    /**
     * 
     * @return 
     */
    protected boolean isFinished() {
        return shooter.isTriggered();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
