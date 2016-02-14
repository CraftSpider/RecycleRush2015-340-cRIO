package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class CGSecureBottomTote extends CommandGroup {
    
    public  CGSecureBottomTote() {
    	addSequential(new StackerGoToPosition(RobotMap.StackerGrabTote1Target, 2));
    	addSequential(new StackerToMin());
    	addSequential(new WaitCommand(.25));
    	addSequential(new StackerGoToPosition(RobotMap.StackerGrabTote1Target, 2));
    }
}
