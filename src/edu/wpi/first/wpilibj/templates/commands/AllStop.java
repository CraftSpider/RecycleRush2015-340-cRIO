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
public class AllStop extends CommandBase {

    public AllStop() {
        requires(gearShift); //requires all subsystems. forces them to stop what they are doing.
        requires(shooter);
        requires(ballIntake);
        requires(drive);       
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      drive.setLeftDrive(0);
      drive.setRightDrive(0);
      ballIntake.ballIntakeRollerStop();
      gearShift.gearLow();
      shooter.stopPull();
      shooter.triggerOut();//TODO: Stop all subsystems
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
