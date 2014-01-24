package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Subsystem for the BallIntake.
 * @author Ryan Pappa
 */
public class BallIntake extends Subsystem {
    private DoubleSolenoid mechanismDeployer1;
    private DoubleSolenoid mechanismDeployer2;
    private Victor  intakeRoller;
    private AnalogChannel ballDetector;
    public int rollerSpeed;
    public double angleSpeed;
    public double shootPosition;
    public double groundPickUp;
    private double ballInDistance = 5;
    
    
    /**
     * Constructor for the BallIntake class.
     */
    public BallIntake()
    {
        mechanismDeployer1 = new DoubleSolenoid(1, 2);
        mechanismDeployer2 = new DoubleSolenoid(3, 4);
        intakeRoller = new Victor(4);
        ballDetector = new AnalogChannel(5);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Method that puts the intake out.
     */
    public void deployIntake()
    {
        mechanismDeployer1.set(DoubleSolenoid.Value.kForward);
        mechanismDeployer2.set(DoubleSolenoid.Value.kForward);
    }
    
    /**
     * Method that puts the intake in.
     */
    public void retractIntake()
    {
        mechanismDeployer1.set(DoubleSolenoid.Value.kReverse);
        mechanismDeployer2.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void goToMid() {
        mechanismDeployer1.set(DoubleSolenoid.Value.kReverse);
        mechanismDeployer2.set(DoubleSolenoid.Value.kForward);
    }

    /**
     * Method that takes the ball in.
     * @param dir - direction 
     */
    public void ballIntakeRollerIn(int dir) {
        intakeRoller.set(dir);
    }
    
    /**
     * Method that takes the ball out.
     * @param dir - direction
     */
    public void ballIntakeRollerOut(int dir) {
        intakeRoller.set(dir);
    }

    /**
     * Method that determines if a ball is in the mechanism or not.
     * @return boolean
     */
    public boolean isBallInMechanism() {
        return ballDetector.getValue() <= ballInDistance;
    }
    /**
     * Method that stops the rollers. 
     */
    public void ballIntakeRollerStop() {
       intakeRoller.set(0);
    }
    
    public boolean isMechanismIn() {
        return mechanismDeployer1.get() == DoubleSolenoid.Value.kReverse && mechanismDeployer2.get() == DoubleSolenoid.Value.kReverse;
    }
    public boolean isMechanismOut() {
        return mechanismDeployer1.get() == DoubleSolenoid.Value.kForward && mechanismDeployer2.get() == DoubleSolenoid.Value.kForward;
    }
    public boolean isMechanismMid() {
        return mechanismDeployer1.get() == DoubleSolenoid.Value.kForward && mechanismDeployer2.get() == DoubleSolenoid.Value.kReverse || mechanismDeployer1.get() == DoubleSolenoid.Value.kReverse && mechanismDeployer2.get() == DoubleSolenoid.Value.kForward;
    }

    public boolean isMechanismWithinThreshold(double shootPosition, double threshold) {
       return false;
    }
}
