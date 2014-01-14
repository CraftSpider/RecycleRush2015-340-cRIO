package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearShift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Solenoid gearSolenoid = new Solenoid(1); //instantiate Solenoid.

    public void gearHigh() {
        gearSolenoid.set(false); //deactivate the solenoid. sets high gear.
    }

    public void gearLow() {
        gearSolenoid.set(true); //activate the solenoid. sets low gear.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
