package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LightRelayOn;

public class LightRelaySubsystem extends Subsystem {

  public Relay relay1;

  public LightRelaySubsystem() {
    relay1 = new Relay(RobotMap.relay1);
  }

  @Override
  public void initDefaultCommand() {
    
  }

  public void on() {
    relay1.set(Relay.Value.kOn);
  }

  public void off() {
    relay1.set(Relay.Value.kOff);
  }
}