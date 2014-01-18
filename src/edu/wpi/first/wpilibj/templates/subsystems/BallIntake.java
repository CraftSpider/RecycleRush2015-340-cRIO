/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogChannel;

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
    private AnalogChannel ballDetector = new AnalogChannel(1);
    // TODO: fill in the two null
    
    
    public final int groundPickUp = 90;
    public final int threshold = 3;
    public final int shootPosition = 0;
    public final double rollerSpeed = .5;
    public final double angleSpeed = .5;
    public final int ultrasonicValueConsideredIn = 10;
    
    
    
    
    
    
    
    public void deployMechanism (double speed){
        mechanismDeployer.set(speed);
    }
    public void retractMechanism(double speed){
        mechanismDeployer.set(-speed);
    }
    public void ballIntakeRollerIn(double speed){
        intakeRoller.set(speed);
    }
    public void ballIntakeRollerOut(double speed){
        intakeRoller.set(-speed);
    }
    public void ballIntakeRollerStop(){
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
    public boolean isBallInMechanism() {
        return ballDetector.getValue() < ultrasonicValueConsideredIn;
    }
            
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
