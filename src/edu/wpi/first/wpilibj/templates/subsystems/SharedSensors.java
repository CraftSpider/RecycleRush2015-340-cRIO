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
     * This method returns the 
     * @return 
     */
    public double getLeftUltrasonicDistance()
    {
        return leftUltrasonic.getValue()/2;
    }
    
    public double getRightUltrasonicDistance()
    {
        return rightUltrasonic.getValue()/2;
    }
    
    public double getAverageUltrasonicDistance()
    {
        return  ( getLeftUltrasonicDistance() + getRightUltrasonicDistance() ) / 2;
    }
    
    public double inferAngleFromUltrasonics()
    {
        // tan^-1(distance between ultras/difference between readings)
        return MathUtils.atan(DISTANCE_BETWEEN_ULTRASONICS /
                (getRightUltrasonicDistance() - getLeftUltrasonicDistance()));
    }
    
    public void ActivateGreenLED()
    {
        greenLED.set(true);
    }
    
    public void ActivateRedLED()
    {
        redLED.set(true);
    }
    
    public void ActivateYellowLED()
    {
        greenLED.set(true);
        redLED.set(true);
    }
    
    public void DeactivateGreenLED()
    {
        greenLED.set(false);
    }
    
    public void DeactivateRedLED()
    {
        redLED.set(false);
    }
    
    public void DeactivateYellowLED()
    {
        greenLED.set(false);
        redLED.set(false);
    }
}