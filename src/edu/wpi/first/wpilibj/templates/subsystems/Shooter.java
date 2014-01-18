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
        // TODO: Change downSensor to whatever we are actually using

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }
    public void pullBack(double Speed) {
        puller.set(Speed);
    }
    public void shoot() {
        trigger.set(false);
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
}
