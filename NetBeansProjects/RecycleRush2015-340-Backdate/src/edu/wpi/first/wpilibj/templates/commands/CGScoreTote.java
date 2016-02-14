package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A command group to score a tote stack at the push of a button.
 * @author Dayle
 */
public class CGScoreTote extends CommandGroup {
    
    public  CGScoreTote() {
    	addSequential(new StackerToMin());
    	addSequential(new FourBarToMax());
    	//addSequential(new StackerGoToNearestNeutralPosition(2));
    }
}