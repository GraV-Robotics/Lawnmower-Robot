package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class LEDOutputSubsystem extends Subsystem {

  public static DigitalOutput ledTogglePin;

  public LEDOutputSubsystem() {
    ledTogglePin = new DigitalOutput(RobotMap.ledSwitch);
  }

  @Override
  public void initDefaultCommand() {
  }

  public static void on() {
    ledTogglePin.set(true);
  }

  public static void off() {
    ledTogglePin.set(false);
  }
}