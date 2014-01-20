package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that turns the rollers on to get the ball.
 * @author Tech
 */
public class GetBall extends CommandBase {
    
    /**
     * Constructor for the GetBall class.
     */
    public GetBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
    }

    /**
     * Method that turns on the rollers.
     */
    protected void initialize() {
        ballIntake.ballIntakeRollerIn(ballIntake.rollerSpeed);
    }

    /**
     * Method that deploys intake.
     */
    protected void execute() {
        
            //TODO add try and catch
        ballIntake.deployIntake();        
    }

    /**
     * Is finished when ball is in mechanism.
     * @return boolean
     */
    protected boolean isFinished() {
        //TODO When the arm has reached the threshold
        return ballIntake.isBallInMechanism();
   
    }

    /**
     * Stops rollers when finished.
     */
    protected void end() {
        ballIntake.ballIntakeRollerStop();
        ballIntake.retractIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
