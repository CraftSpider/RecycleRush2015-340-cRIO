package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 * @author Ryan Pappa
 */
//this is a test comment to see if git is working
public class BallIntake extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private DoubleSolenoid mechanismDeployer1;
    private DoubleSolenoid mechanismDeployer2;
    private Victor  intakeRoller;
    private AnalogChannel ballDetector;
    
    
    public BallIntake()
    {
        mechanismDeployer1 = new DoubleSolenoid(1, 2);
        mechanismDeployer2 = new DoubleSolenoid(3, 4);
        intakeRoller = new Victor(4);
        ballDetector = new AnalogChannel(5);
    }
    
    public void deployIntake()
    {
        mechanismDeployer1.set(DoubleSolenoid.Value.kForward);
        mechanismDeployer2.set(DoubleSolenoid.Value.kForward);
    }
    public void retractIntake()
    {
        mechanismDeployer1.set(DoubleSolenoid.Value.kReverse);
        mechanismDeployer2.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
