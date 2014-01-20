/**
 * @author Tyler Pawlaczyk
 * <p>A subsystem to contain the sensors required by Drive and Shooter</p>
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;



public class SharedSensors extends Subsystem
{
    private AnalogChannel leftUltrasonic, rightUltrasonic;
    private DigitalInput leftLineReader, rightLineReader;
    private Solenoid greenLED, redLED;
    
    private static final double DISTANCE_BETWEEN_ULTRASONICS = 19; //inches
    
    public SharedSensors(int leftUltraPort, int rightUltraPort, int leftReaderPort, int rightReaderPort)
    {
        leftUltrasonic = new AnalogChannel(leftUltraPort);
        rightUltrasonic = new AnalogChannel(rightUltraPort);
        
        leftLineReader = new DigitalInput(leftReaderPort);
        rightLineReader = new DigitalInput(rightReaderPort);
    }
    
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * This method returns the left ultrasonic.
     * @return double
     */
    public double getLeftUltrasonicDistance()
    {
        return leftUltrasonic.getValue()/2;
    }
    
    /**
     * This method returns the right ultrasonic.
     * @return double
     */
    public double getRightUltrasonicDistance()
    {
        return rightUltrasonic.getValue()/2;
    }
    
    /**
     * This method returns the ultrasonic average.
     * @return double
     */
    public double getAverageUltrasonicDistance()
    {
        return  ( getLeftUltrasonicDistance() + getRightUltrasonicDistance() ) / 2;
    }
    
    /**
     * tan^-1(distance between ultras/difference between readings)
     * @return double
     */
    public double inferAngleFromUltrasonics()
    { 
        return MathUtils.atan(DISTANCE_BETWEEN_ULTRASONICS /
                (getRightUltrasonicDistance() - getLeftUltrasonicDistance()));
    }
    
    /**
     * Turns on the green LED.
     */
    public void ActivateGreenLED()
    {
        greenLED.set(true);
    }
    
    /**
     * Turns on the red LED.
     */
    public void ActivateRedLED()
    {
        redLED.set(true);
    }
    
    /**
     * Turns on the yellow LED.
     */
    public void ActivateYellowLED()
    {
        greenLED.set(true);
        redLED.set(true);
    }
    
    /**
     * Turns off the green LED.
     */
    public void DeactivateGreenLED()
    {
        greenLED.set(false);
    }
    
    /**
     * Turns off the red LED.
     */
    public void DeactivateRedLED()
    {
        redLED.set(false);
    }
    
    /**
     * Turns off the yellow LED.
     */
    public void DeactivateYellowLED()
    {
        greenLED.set(false);
        redLED.set(false);
    }
}