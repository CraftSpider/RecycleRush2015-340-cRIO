/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.buttons.AnalogIOButton;
import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 * @author Ryan Pappa
 */
public class Shooter extends Subsystem {
    
        public final int TRUSS_POSITION = 42;
        public final int ARM_POSITIONING_THRESHOLD = 3;
        public final double PULL_SPEED = .5;

        private Solenoid trigger;
        private Victor puller;
        private DigitalInput downSensor;
        // TODO: Remove armPosition if we won't have a potentiometer
        private AnalogChannel armPosition;
        
        
    public Shooter()
    {
        trigger = new Solenoid(2);
        puller  = new Victor(6);
        downSensor  = new DigitalInput(1);
        armPosition = new AnalogChannel(3);
    }

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }
    
    public void pullBack(double Speed)
    {
        puller.set(Speed);
    }
    
    public void stopPull()
    {
        puller.set(0);
    }
    
    public boolean isDown()
    {
        return downSensor.get();
    }
    
    public boolean isTriggered()
    {
        return !trigger.get();
    }
    
    public void triggerIn()
    {
        trigger.set(true);
    }
    
    public void triggerOut()
    {
        trigger.set(false);
    }
    
    public void shoot() //Same function as triggerOut. Consider revision.
    { 
        trigger.set(false);
    } 
    
    public int getPosition()
    {
        return armPosition.getValue();
    }
}
