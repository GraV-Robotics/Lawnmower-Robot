package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.LawnmowerBladeOn;
import frc.robot.commands.LightRelayOn;

public class OI {

  public static Joystick joystick1 = new Joystick(RobotMap.joystick1);
  public static Joystick joystick2 = new Joystick(RobotMap.joystick2);
  public static Button lightRelayButton =  new JoystickButton(joystick1, RobotMap.lightRelayButton);
  public static Button lawnmowerButton = new JoystickButton(joystick2, RobotMap.lawnmowerBladeButton);

  public OI() {
    lawnmowerButton.whenPressed(new LawnmowerBladeOn());
    lightRelayButton.whenPressed(new LightRelayOn());
  }
}