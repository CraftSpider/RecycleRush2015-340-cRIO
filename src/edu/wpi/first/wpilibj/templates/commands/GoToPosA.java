/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author grr340
 */
public class GoToPosA extends CommandBase {
    private int angle;
    private double speed = .5;
    private static final int threshhold = 5;
    
    public GoToPosA(int pos) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
        angle = pos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(ballIntake.mechanismDeltaAngle(angle) >= 0){
            ballIntake.deployMechanism(speed);
        }
        else {
            ballIntake.retractMechanism(speed);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ballIntake.isMechanismWithinThreshold(angle, threshhold);
    }
    

    // Called once after isFinished returns true
    protected void end() {
        ballIntake.mechanismStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
