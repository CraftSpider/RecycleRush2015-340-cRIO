/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that puts the ball intake to the shooting position.
 * @author tech
 */
public class BallIntakeGoToShootingPos extends CommandBase {
    
    /**
     * Constructor for the BallIntakeGoToShootingPos class.
     */
    public BallIntakeGoToShootingPos() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    /**
     * Method that retracts the ball intake.
     */
    protected void execute() {
        ballIntake.retractIntake();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ballIntake.isMechanismMid();
    }

    /**
     * Stops the rollers when finished.
     */
    protected void end() {
        
        ballIntake.ballIntakeRollerStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
