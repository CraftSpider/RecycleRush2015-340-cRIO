package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.SharedSensors;

/**
 * Command that lights up LED according to how far away you are.
 * @author Robotics
 */
public class InformAtDistance extends CommandBase {
    
    /**
     * Constructor for the InformAtDistance class.
     */
    public InformAtDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(sharedSensors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Lights up LED's according to the distance.
     */
    protected void execute() {
        double Distance = sharedSensors.getAverageUltrasonicDistance();
        
        if (Distance <= 50) {
            sharedSensors.ActivateRedLED();
        }
        if (Distance <= 25) {
            sharedSensors.DeactivateRedLED();
            sharedSensors.ActivateYellowLED();
        }
        if (Distance <= 10) {
            sharedSensors.DeactivateYellowLED();
            sharedSensors.ActivateGreenLED();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}