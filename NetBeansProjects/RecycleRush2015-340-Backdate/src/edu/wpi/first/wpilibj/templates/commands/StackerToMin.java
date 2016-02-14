package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * Command which will send the stacker arm to its maximum position.
 * @author Jakob W.
 */
public class StackerToMin extends CommandBase {

    public StackerToMin() {
        // Use requires() here to declare subsystem dependencies
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[StackerToMin: initialize] ");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("[StackerToMin: execute] encoderVal: "+stacker.getStackerPosition());
    	if (!stacker.isStackerMin()) {
    		stacker.stackerMoveDown(RobotMap.StackerDownSpeed/2);
    		System.out.println("[StackerToMin: execute] Move Stacker Down");
		}
    	else {
    		stacker.stackerStopVertical();
    		System.out.println("[StackerToMin: execute] Stop, Stacker Has Reached Bottom");
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stacker.isStackerMin();
    }

    // Called once after isFinished returns true
    protected void end() {
		System.out.println("[StackerToMin: end] Stop Stacker");

    	stacker.stackerStopVertical();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		System.out.println("[StackerToMin: interrupted] Stop Stacker");

    	stacker.stackerStopVertical();
    }
}
