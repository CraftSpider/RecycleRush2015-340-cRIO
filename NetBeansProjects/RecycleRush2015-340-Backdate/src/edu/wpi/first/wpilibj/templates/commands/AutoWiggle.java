package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoWiggle extends CommandGroup {
    
    public  AutoWiggle() {
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
    	addSequential(new DriveSide(true, -.5), .15);
    	addSequential(new WaitCommand(.125), .125);
    	addSequential(new DriveSide(true, .5), .3);
    	addSequential(new WaitCommand(.2), .2);
    	addSequential(new DriveSide(true, -.5), .15);
    	addSequential(new WaitCommand(.125), .125);
    	addSequential(new DriveSide(false, -.5), .15);
    	addSequential(new WaitCommand(.125), .125);
    	addSequential(new DriveSide(false, .5), .3);
    	addSequential(new WaitCommand(.2), .2);
    	addSequential(new DriveSide(false, -.5), .15);
    }
}
