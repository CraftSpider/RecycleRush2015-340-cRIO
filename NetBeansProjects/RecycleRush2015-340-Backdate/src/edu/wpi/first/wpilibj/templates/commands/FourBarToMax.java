package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command Which will send four bar manipulator to max.
 * 
 * @author Kyle W.
 */
public class FourBarToMax extends CommandBase {

	public FourBarToMax() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(fourBar);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("[FourBarToMax: initialize] ");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
            /*if(fourBar.isFailedTest()){
        	oi.coDriverRumbleOn();
            }*/
            if (!fourBar.isMax()) {
		System.out.println("[FourBarToMax: execute] moving up");
		fourBar.moveUp(true);
            }else{
		fourBar.stopMovement();
            }
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return fourBar.isMax();
	}

	// Called once after isFinished returns true
	protected void end() {
            System.out.println("[FourBarToMax: end] stop moving");
//          oi.coDriverRumbleOff();
            fourBar.stopMovement();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
            System.out.println("[FourBarToMax: interrupted] stop moving");
//          oi.coDriverRumbleOff();
            fourBar.stopMovement();
	}
}
