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
        requires(sharedSensors);
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
            System.out.println("Shoot");
            //shooter.setRachetWinch(.5);
            //if (shooter.isArmDown()) {
            //    shooter.shoot();
            //}
        }
    }
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}