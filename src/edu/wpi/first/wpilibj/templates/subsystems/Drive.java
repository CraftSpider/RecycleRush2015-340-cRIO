package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

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

    public Drive()
    {
        leftDrive1 = new Talon(1);
        leftDrive2 = new Talon(2);
        leftDrive3 = new Talon(3);
        
        rightDrive1 = new Talon(4);
        rightDrive2 = new Talon(5);
        rightDrive3 = new Talon(6);
        
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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
    
}
