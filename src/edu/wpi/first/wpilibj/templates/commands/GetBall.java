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
public class GetBall extends CommandBase {
    
    
    public GetBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ballIntake.ballIntakeRollerIn(ballIntake.rollerSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
            //TODO add try and catch
        ballIntake.deployIntake();        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //TODO When the arm has reached the threshold
        return ballIntake.isBallInMechanism();
   
    }

    // Called once after isFinished returns true
    protected void end() {
        ballIntake.ballIntakeRollerStop();
        ballIntake.retractIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
