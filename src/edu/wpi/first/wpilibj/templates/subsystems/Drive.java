package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;

/**
 * Subsystem for the Drive.
 * @author Tyler Pawlaczyk
 */
public class Drive extends Subsystem {
    
    Talon leftDrive1; 
    Talon leftDrive2; 
    Talon leftDrive3;
    Talon rightDrive1;
    Talon rightDrive2;
    Talon rightDrive3;
    public double leftMotorSpeed;
    public double rightMotorSpeed;

    /**
     * Constructor for the Drive class.
     */
    public Drive()
    {
        leftDrive1 = new Talon(1);//was port 1
        leftDrive2 = new Talon(2);
        leftDrive3 = new Talon(3);
        
        rightDrive1 = new Talon(4);
        rightDrive2 = new Talon(5);
        rightDrive3 = new Talon(6);   
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoystick());
    }

    /**
     * Sets the speed for the left drive.
     * @param double speed 
     */
    public void setLeftDrive(double speed)
    {
        leftDrive1.set(speed);
        leftDrive2.set(speed);
        leftDrive3.set(speed);
    }
    
    /**
     * Sets the speed for the right drive.
     * @param double speed 
     */
    public void setRightDrive(double speed)
    {
        rightDrive1.set(speed);
        rightDrive2.set(speed);
        rightDrive3.set(speed);
    }   
    
    /**
     * Sets the speed for both sides.
     * @param double leftOutput
     * @param double rightOutput 
     */
    private void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
        this.setLeftDrive(leftOutput);
        this.setRightDrive(rightOutput);
    }
    
    /**
     * Allows for the driver to control the robot with arcade drive.
     * @param double moveValue
     * @param double rotateValue
     * @param boolean squaredInputs 
     */
     public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs) 
     {
        if (squaredInputs) 
        {
            // square the inputs (while preserving the sign) to increase fine control while permitting full power       
            if (moveValue >= 0.0) 
            {
                moveValue = (moveValue * moveValue);
            } 
            
            else 
            {
                moveValue = -(moveValue * moveValue);
            }
            
            if (rotateValue >= 0.0)
            {
                rotateValue = (rotateValue * rotateValue);
            }
            
            else
            {
                rotateValue = -(rotateValue * rotateValue);
            }
            
            if (moveValue > 0.0) 
            {
            
                if (rotateValue > 0.0) 
                {
                    leftMotorSpeed = moveValue - rotateValue;
                    rightMotorSpeed = Math.max(moveValue, rotateValue);
                } 
            
                else 
                {
                    leftMotorSpeed = Math.max(moveValue, -rotateValue);
                    rightMotorSpeed = moveValue + rotateValue;
                }
            }
            
            else 
            {
                if (rotateValue > 0.0) 
                {
                    leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                    rightMotorSpeed = moveValue + rotateValue;
                } 
                else 
                {
                    leftMotorSpeed = moveValue - rotateValue;
                    rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
                }
            }
        this.setLeftRightMotorOutputs(leftMotorSpeed, -rightMotorSpeed); //rightMotorSpeed negated.
      }
   }
}