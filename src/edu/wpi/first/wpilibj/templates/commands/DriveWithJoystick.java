package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that allows the robot to be driven with joysticks.
 * @author grr340
 */
public class DriveWithJoystick extends CommandBase {

    /**
     * Constructor for the DriveWithJoystick class.
     */
    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Takes user input and sets motors.
     */
    protected void execute() 
    {
        drive.arcadeDrive(oi.getDriveMove(), oi.getDriveRotate(), true);
        System.out.println("drive left:" + drive.leftMotorSpeed);
        System.out.println("drive right:" + drive.rightMotorSpeed);
        System.out.println("Ultrasonic Average:" + sharedSensors.getAverageUltrasonicDistance());
        System.out.println("Ultrasonic left:" + sharedSensors.getLeftUltrasonicDistance());
        System.out.println("Ultrasonic right:" + sharedSensors.getRightUltrasonicDistance());
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