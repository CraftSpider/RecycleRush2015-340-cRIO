package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.buttons.AnalogIOButton;
import edu.wpi.first.wpilibj.AnalogChannel;

/**
 * Subsystem for the Shooter.
 * @author Ryan Pappa
 */
public class Shooter extends Subsystem {
    
        public final int TRUSS_POSITION = 42;
        public final int ARM_POSITIONING_THRESHOLD = 3;
        public final double PULL_SPEED = .5;

        private Solenoid winchRelease;
        private Victor rachetWinch;
        private DigitalInput isArmDownSensor;
        // TODO: Remove armPosition if we won't have a potentiometer
        private AnalogChannel armPosition;
        
    /**
     * Constructor for the Shooter class.
     */    
    public Shooter()
    {
        winchRelease = new Solenoid(2);
        rachetWinch  = new Victor(6);
        isArmDownSensor  = new DigitalInput(1);
        armPosition = new AnalogChannel(3);
    }

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Method that pulls back the winchRelease.
     * @param double speed 
     */
    public void setRachetWinch(double speed)
    {
        rachetWinch.set(speed);
    }
    
    /**
     * Method that stops pulling the winchRelease.
     */
    public void stopRachetWinch()
    {
        rachetWinch.set(0);
    }
    
    /**
     * Determines if the winchRelease is down.
     * @return boolean
     */
    public boolean isArmDown()
    {
        return isArmDownSensor.get();
    }
    
    /**
     * Determines if the winchRelease is down.
     * @return boolean
     */
    public boolean isTriggered()
    {
        return !winchRelease.get();
    }
    
    /**
     * Sets the winchRelease in.
     */
    public void setTriggerIn()
    {
        winchRelease.set(true);
    }
    
    /**
     * Sets the winchRelease out.
     */
    public void setTriggerOut()
    {
        winchRelease.set(false);
    }
    
    /**
     * Shoots the ball.
     */
    public void shoot() //Same function as setTriggerOut. Consider revision.
    { 
        winchRelease.set(false);
    } 
    
    /**
     * 'Returns the position of the arm.
     * @return int
     */
    public int getArmPosition()
    {
        return armPosition.getValue();
    }
}