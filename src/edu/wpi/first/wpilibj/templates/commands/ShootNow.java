package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that shoots the balla now.
 * @author grr340
 */
public class ShootNow extends CommandBase {
    
    /**
     * Constructor for the ShootNow class.
     */
    public ShootNow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Shoots the ball.
     */
    protected void execute() {
        shooter.setTriggerOut();
    }

   /**
    * Is finished when it is triggered.
    * @return 
    */
    protected boolean isFinished() {
        return shooter.isTriggered();
    }

    /**
     * Puts the trigger in.
     */
    protected void end() {
        shooter.setTriggerIn();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
