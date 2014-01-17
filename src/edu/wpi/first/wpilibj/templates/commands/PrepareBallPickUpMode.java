/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Tech
 */
public class PrepareBallPickUpMode extends CommandBase {
    
    double rollerSpeed = 0;
    double angleSpeed = 0;
    
    public PrepareBallPickUpMode() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ballIntake.ballIntakeIn(rollerSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        while(isFinished()){
            //TODO add try and catch
            ballIntake.deployMechanism(angleSpeed);
        }
        end();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //TODO When the arm has reached the threshold
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
