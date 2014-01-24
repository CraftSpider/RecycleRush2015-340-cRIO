package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that allows us to shoot the ball at a distance.
 * @author Robotics
 */
public class ShootAtDistance extends CommandBase {
    private static final double DISTANCE_TO_SHOOT_FROM = 10;
    
    /**
     * Constructor for the ShootAtDistance class.
     */
    public ShootAtDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
        requires(drive);
    }

    /**
     * Method that puts the trigger in.
     */
    protected void initialize() {
        shooter.setTriggerIn();
    }

    /**
     * Method that allows us to shoot if we are close enough.
     */
    protected void execute() {
        if (sharedSensors.getAverageUltrasonicDistance() <= DISTANCE_TO_SHOOT_FROM) {
            shooter.setTriggerOut();
            //shooter.setRachetWinch(.5);
            //if (shooter.isArmDown()) {
            //    shooter.shoot();
            //}
        } else {
            drive.setLeftDrive(DRIVE_SPEED);
            drive.setRightDrive(DRIVE_SPEED);
        }
    }
    public static final double DRIVE_SPEED = .5;
    /**
     * Is finished when it is triggered.
     * @return boolean
     */
    protected boolean isFinished() {
        return shooter.isTriggered();
    }

    /**
     * Puts the trigger in.
     */
    protected void end() {
        shooter.setTriggerIn();
        drive.setLeftDrive(0);
        drive.setRightDrive(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}