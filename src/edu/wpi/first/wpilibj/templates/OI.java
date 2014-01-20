package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Joystick xboxDriverController1 = new Joystick(1);
    Button buttonA1 = new JoystickButton(xboxDriverController1, 1);
    Button buttonB1 = new JoystickButton(xboxDriverController1, 2);
    Button buttonX1 = new JoystickButton(xboxDriverController1, 3);
    Button buttonY1 = new JoystickButton(xboxDriverController1, 4);
    Button buttonLB1 = new JoystickButton(xboxDriverController1, 5);
    Button buttonRB1 = new JoystickButton(xboxDriverController1, 6);
    Button buttonBack1 = new JoystickButton(xboxDriverController1, 7);
    Button buttonStart1 = new JoystickButton(xboxDriverController1, 8);
    
    Joystick xboxCoDriverController = new Joystick(2);
    Button buttonA2 = new JoystickButton(xboxCoDriverController, 1);
    Button buttonB2 = new JoystickButton(xboxCoDriverController, 2);
    Button buttonX2 = new JoystickButton(xboxCoDriverController, 3);
    Button buttonY2 = new JoystickButton(xboxCoDriverController, 4);
    Button buttonLB2 = new JoystickButton(xboxCoDriverController, 5);
    Button buttonRB2 = new JoystickButton(xboxCoDriverController, 6);
    Button buttonBack2 = new JoystickButton(xboxCoDriverController, 7);
    Button buttonStart2 = new JoystickButton(xboxCoDriverController, 8);

    /**
     * Constructor for the OI class.
     */
    public OI() {
        buttonA1.whenPressed(new GetBall());
        buttonB1.whenPressed(new BallIntakeGoToLoadPosition());
        buttonX1.whenPressed(new BallIntakeGoToShootingPos());
        buttonLB1.whenPressed(new GearUp());
        buttonRB1.whenPressed(new GearDown());
        buttonBack1.whenPressed(new AllStop());
        buttonBack2.whenPressed(new AllStop());
        
        
    }

    /**
    * Accessor method for the x-axis of the drivers controller.
    * @return the x-axis of the driver controller. 
     */
    public double getDriveMove() {
        return xboxDriverController1.getRawAxis(2); //x-axis
    }

    /**
    * Accessor method for the y-axis of the drivers controller.
    * @return the y-axis of the driver controller. 
    */
    public double getDriveRotate() {
        return xboxDriverController1.getRawAxis(1); //y-axis
    }

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
