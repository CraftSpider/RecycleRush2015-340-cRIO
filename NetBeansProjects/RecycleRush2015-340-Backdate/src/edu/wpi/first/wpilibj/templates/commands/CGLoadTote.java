package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * Lifts the bottom tote to the third position for use at the human player station.
 */
public class CGLoadTote extends CommandGroup {
    
    public  CGLoadTote() {
    	addSequential(new StackerGoToPosition(RobotMap.StackerNeutralTote2Target, 2), 10.0);
    	addSequential(new WaitCommand(.5));
    	addSequential(new StackerToMax(), 10.0);
    }
}
