/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author tech
 */
public class BallIntakeGoToShootingPos extends CommandBase {
    
    public BallIntakeGoToShootingPos() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ballIntake.retractMechanism(ballIntake.angleSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ballIntake.isMechanismWithinThreshold(ballIntake.shootPosition, ballIntake.threshold);
        
    }

    // Called once after isFinished returns true
    protected void end() {
        ballIntake.ballIntakeStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}