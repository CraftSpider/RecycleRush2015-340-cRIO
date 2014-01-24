package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that stops all processes.
 * @author Tech
 */
public class AllStop extends CommandBase {

    /**
     * Constructor for the AllStop class.
     */
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

   /**
    * Method that stops all processes.
    */
    protected void execute() {
      drive.setLeftDrive(0);
      drive.setRightDrive(0);
      ballIntake.ballIntakeRollerStop();
      gearShift.gearLow();
      shooter.stopRachetWinch();
      shooter.setTriggerOut();//TODO: Stop all subsystems
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