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
public class BallIntakeEjectBall extends CommandBase {
    
    public BallIntakeEjectBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ballIntake.retractIntake();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ballIntake.ballIntakeRollerOut(ballIntake.rollerSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !ballIntake.isMechanismIn();
    }

    // Called once after isFinished returns true
    protected void end() {
        ballIntake.ballIntakeRollerStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
