/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Tech
 */
public class Drive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    CANJaguar leftDrive1;
    CANJaguar leftDrive2;
    CANJaguar leftDrive3;
    CANJaguar rightDrive1;
    CANJaguar rightDrive2;
    CANJaguar rightDrive3;

    public Drive() {
        try {
            this.leftDrive1 = new CANJaguar(2);
            this.leftDrive2 = new CANJaguar(3);
            this.leftDrive3 = new CANJaguar(4);
            this.rightDrive1 = new CANJaguar(5);
            this.rightDrive2 = new CANJaguar(6);
            this.rightDrive3 = new CANJaguar(7);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void setLeftDrive(double speed) {
        try {
            leftDrive1.setX(speed);
            leftDrive2.setX(speed);
            leftDrive3.setX(speed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void setRightDrive(double speed) {
        try {
            rightDrive1.setX(speed);
            rightDrive2.setX(speed);
            rightDrive3.setX(speed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

}
