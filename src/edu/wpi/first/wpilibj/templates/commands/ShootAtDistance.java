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
public class ShootAtDistance extends CommandBase {
    private static final double DISTANCE_TO_SHOOT_FROM = 10;
    
    public ShootAtDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
        requires(sharedSensors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.triggerIn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (sharedSensors.getAverageUltrasonicDistance() <= DISTANCE_TO_SHOOT_FROM) {
            shooter.pullBack(.5);
            if (shooter.isDown()) {
                shooter.shoot();
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return shooter.isTriggered();
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.triggerIn();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
