/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Robotics
 */
public class DriveToDistance extends CommandBase {
    private static final double DISTANCE_TO_DRIVE_TO = 10;
    private static final double SPEED_OF_DRIVE = .5;
    
    public DriveToDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(sharedSensors);
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        while (sharedSensors.getAverageUltrasonicDistance() >= DISTANCE_TO_DRIVE_TO) {
            drive.setLeftDrive(SPEED_OF_DRIVE);
            drive.setRightDrive(SPEED_OF_DRIVE);
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
