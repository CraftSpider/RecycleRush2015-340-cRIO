/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Robotics
 */
//this is a test comment to see if git is working
public class BallIntake extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Victor mechanismDeployer = new Victor(3);
    Victor intakeRoller = new Victor(4);
    AnalogChannel mechanismAngleMeter = new AnalogChannel(1);
    
    
    
    public void deployMechanism (double speed){
        
    }
    public void retractMechanism(double speed){
        
    }
    public void ballIntakeIn(double speed){
        intakeRoller.set(speed);
    }
    public void ballIntakeOut(double speed){
        intakeRoller.set(-speed);
    }
    public void ballIntakeStop(){
        intakeRoller.set(0);
    }
    public double mechanismDeltaAngle(int angle){
        return angle - mechanismAngleMeter.getValue();
    }
    public boolean isMechanismWithinThreshold(int angle, double threshold){
        if(mechanismDeltaAngle(angle) < threshold)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
            
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
