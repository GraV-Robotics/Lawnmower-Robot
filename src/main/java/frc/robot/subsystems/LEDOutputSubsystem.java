package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class LEDOutputSubsystem extends Subsystem {

  public DigitalOutput ledTogglePin;

  public LEDOutputSubsystem() {
    ledTogglePin = new DigitalOutput(RobotMap.ledSwitch);
  }

  @Override
  public void initDefaultCommand() {
  }

  public void on() {
    ledTogglePin.set(true);
  }

  public void off() {
    ledTogglePin.set(false);
  }
}