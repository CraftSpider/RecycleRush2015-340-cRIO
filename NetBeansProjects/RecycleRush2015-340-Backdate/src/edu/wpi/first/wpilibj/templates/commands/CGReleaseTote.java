package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGReleaseTote extends CommandGroup {
    
    public  CGReleaseTote() {
    	addSequential(new MO_FourBarClawOpen());
    	addSequential(new FourBarToMax());
//    	addSequential(new DriveStraight(-1, 5));
    }
}
