package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.subsystems.LevelManager;

/**
 *
 */
public class CGScoreGarbageBin extends CommandGroup {
    
    public  CGScoreGarbageBin() {
    	addSequential(new MO_FourBarClawClose());
    	addSequential(new FourBarGoToLevel(LevelManager.getLevel(),10));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new MO_FourBarClawOpen());
    }
}
