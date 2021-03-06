package edu.wpi.first.wpilibj.templates.commands;

//Simport org.usfirst.frc.team340.robot.RobotMap;

/**
 * Command to use the bin grabber to pick up a bin.
 * Potentially obsolete and I'm not sure what's up with the formatting in Eclipse
 * @author Dayle
 */
public class BinGrabberGetBin extends CommandBase {

    public BinGrabberGetBin() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (binGrabber);
    }

//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	System.out.println("[BinGrabberGetBin: initialize] contracts grabber");
//    	binGrabber.contractGrabber();
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	if (binGrabber.isGrabberLowered()){
//    		System.out.println("[BinGrabberGetBin: execute] lowered, stop moving, expand grabber");
//    		binGrabber.expandGrabber();
//    		binGrabber.stopMoving();
//    	}
//    	else {
//    		System.out.println("[BinGrabberGetBin: execute] lowering  grabber");
//    		binGrabber.lowerGrabber();
//    	}
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return binGrabber.isBinGrabbed();
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	System.out.println("[BinGrabberGetBin: end] raise grabber");
//    	binGrabber.raiseGrabber();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	System.out.println("[BinGrabberGetBin: interrupted] stop moving");
//    	//TODO: Add code here for when it is interrupted
//    	binGrabber.stopMoving();
//    }
 // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[BinGrabberGetBin: initialize] ");
    	this.setTimeout(.26);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("[BinGrabberGetBin: execute] un-hooking string");
    	binGrabber.raiseHook();
    	System.out.println("[BinGrabberGetBin: execute] lowered, stop moving");
    	binGrabber.stopMoving();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[BinGrabberGetBin: end] raise hook");
    	binGrabber.stopMoving();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[BinGrabberGetBin: interrupted] stop moving");
    	binGrabber.stopMoving();
    }

}
