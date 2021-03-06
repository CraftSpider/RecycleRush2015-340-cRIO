package edu.wpi.first.wpilibj.templates.commands;

//import edu.wpi.first.wpilibj.command.Command;

/**
 * this doesn't end so watch out make sure you timeout
 */
public class DriveNoEncoders extends CommandBase {
	private double speed;
    public DriveNoEncoders(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive.setLeftRightMotorOutputs(speed, speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.setLeftRightMotorOutputs(speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.setLeftRightMotorOutputs(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drive.setLeftRightMotorOutputs(0, 0);
    }
}
