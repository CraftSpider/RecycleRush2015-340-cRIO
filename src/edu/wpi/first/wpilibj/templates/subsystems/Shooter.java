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
 * @author Robotics
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
        private Solenoid trigger = new Solenoid(1);
        private Victor puller = new Victor(6);
        private DigitalInput downSensor = new DigitalInput(1);
        private AnalogChannel armPosition = new AnalogChannel(3);
        // TODO: Remove armPosition if we won't have a potentiometer

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }
    public void pullBack(double Speed) {
        puller.set(Speed);
    }
    public void stopPull() {
        puller.set(0);
    }
    public boolean isDown() {
        return downSensor.get();
    }
    public boolean isTriggered() {
        return !trigger.get();
    }
    public void triggerIn() {
        trigger.set(true);
    }
    public void triggerOut() {
        trigger.set(false);
    }
    public void shoot() { 
        trigger.set(false);
    //Same function as triggerOut. Consider revision.    
    } 
    public void getPosition() {
        armPosition.getValue();
    }
}
