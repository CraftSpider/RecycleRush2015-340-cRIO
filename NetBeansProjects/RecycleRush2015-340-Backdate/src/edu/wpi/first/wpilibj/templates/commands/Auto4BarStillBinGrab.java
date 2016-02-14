package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto4BarStillBinGrab extends CommandGroup {
    
    public  Auto4BarStillBinGrab() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addParallel(new StackerToMin(), 4);
    	addSequential(new FourBarToMin());
    	addSequential(new FourBarSafeUp(), .42);
    	addParallel(new DriveStraight(.3, 100), .5);
    	addSequential(new FourBarGrabBin());
    }
}
