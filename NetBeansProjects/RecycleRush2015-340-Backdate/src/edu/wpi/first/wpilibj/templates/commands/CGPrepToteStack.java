package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
//import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class CGPrepToteStack extends CommandGroup {
    
    public  CGPrepToteStack() {

    	addSequential(new StackerGoToPosition(RobotMap.StackerGrabTote1Target, 2));
    	addSequential(new StackerToMin());
    	addSequential(new StackerGoToPosition(RobotMap.StackerNeutralTote3Target, 2));
    }
}