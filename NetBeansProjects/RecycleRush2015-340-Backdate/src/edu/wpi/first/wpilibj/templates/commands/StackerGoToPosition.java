package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

//import edu.wpi.first.wpilibj.PIDController.Tolerance;

/**
 * Command to send the stacker arm to a specific position
 * @author Jakob W.
 */
public class StackerGoToPosition extends CommandBase {

    private int target;
	private int tolerance;
	private int initDelta;
	private int start;
	private int currentPos;
	private double percent;
	private double speed;

	public StackerGoToPosition(int position, int tolerance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    	this.target = position;
    	this.tolerance = tolerance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentPos = stacker.getStackerPosition();
    	start = currentPos;
    	initDelta = target - start;
    	percent = 0.1;
    	speed = RobotMap.StackerMaxUpSpeed;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentPos = stacker.getStackerPosition();
    	speed = RobotMap.StackerMaxUpSpeed;
		/*if (stacker.getStackerPosition() < (position-tolerance)) {
    		stacker.stackerMoveUp(.75);
    	}
    	else if (stacker.getStackerPosition() > (position+tolerance)) {
    		stacker.stackerMoveDown(.75);
    	}
    	else {
    		stacker.stackerStopVertical();
    	}*/
    	// checks to see if at position
    	if (((Math.abs(currentPos) <= (Math.abs(target) + tolerance)) 
    			&& (Math.abs(currentPos) >= Math.abs(target) - tolerance))) {
    		stacker.stackerStopVertical();
    		speed = 0;
		}
    	// Checks to see if we are within a percentage from the target position.
    	else if ((Math.abs(currentPos) >= (Math.abs(target) - (Math.abs(initDelta) * percent)))) {
    		speed = RobotMap.StackerMaxUpSpeed * 0.5;
    	}
    	// If the stacker is not close to or at the position the stacker moves moves at full speed.
    	else{
    		speed = RobotMap.StackerMaxUpSpeed;
    	}
 
    	// current delta.
    	int currDelta = target - currentPos;
    	
    	//if delta is positive then move up
    	if(currDelta > 0 && !stacker.isStackerMax()){
    		stacker.stackerMoveUp(speed);
    	}
    	// if delta is negative move down.
    	else if (currDelta < 0 && !stacker.isStackerMin()) {
			stacker.stackerMoveDown(speed);
		}
    	// Tells the stacker to stop if it should not move up or down.
    	else{
    		stacker.stackerStopVertical();
    	}
    	System.out.println("[StackerGoToPosition: execute] slowed down before getting to position to stop:"
    			+ " isStackerMin:" + stacker.isStackerMin()
    			+ " currentPosVal:" + this.currentPos 
    			+ " targetVal:" + this.target 
    			+ " toleranceVal:" + this.tolerance 
    			+ " initDeltaVal:" + this.initDelta 
    			+ " percentVal:" + this.percent
    			+ " currDeltaVal:" + currDelta);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((stacker.getStackerPosition() > (target-tolerance)) && (stacker.getStackerPosition() < (target+tolerance))
        		|| speed==0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	stacker.stackerStopVertical();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	stacker.stackerStopVertical();
    }
}
