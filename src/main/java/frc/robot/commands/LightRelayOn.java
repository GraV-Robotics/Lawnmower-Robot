package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.LightRelaySubsystem;

public class LightRelayOn extends Command {
  public LightRelayOn() {
    requires(new LightRelaySubsystem());
    setTimeout(60);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    LightRelaySubsystem.on();
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    LightRelaySubsystem.off();
  }

  @Override
  protected void interrupted() {
    LightRelaySubsystem.off();
  }
}