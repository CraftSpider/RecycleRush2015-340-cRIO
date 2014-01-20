package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;

/**
 *
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

    public Drive()
    {
        leftDrive1 = new Talon(10);//was port 1
        leftDrive2 = new Talon(2);
        leftDrive3 = new Talon(7);
        
        rightDrive1 = new Talon(8);
        rightDrive2 = new Talon(5);
        rightDrive3 = new Talon(9);   
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoystick());
    }

    public void setLeftDrive(double speed)
    {
            leftDrive1.set(speed);
            leftDrive2.set(speed);
            leftDrive3.set(speed);
    }

    public void setRightDrive(double speed)
    {
            rightDrive1.set(speed);
            rightDrive2.set(speed);
            rightDrive3.set(speed);
    }   
    
    private void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
        this.setLeftDrive(leftOutput);
        this.setRightDrive(rightOutput);
    }
    
     public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs) 
     {
        // local variables to hold the computed PWM values for the motors


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